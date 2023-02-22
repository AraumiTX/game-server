package jp.assasans.araumi.tx.server.ecs

import kotlin.reflect.KClass
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import mu.KotlinLogging
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import jp.assasans.araumi.tx.server.protocol.command.ComponentAddCommand
import jp.assasans.araumi.tx.server.protocol.command.ComponentRemoveCommand
import jp.assasans.araumi.tx.server.protocol.toShareCommand
import jp.assasans.araumi.tx.server.protocol.toUnshareCommand

class Entity(
  override val id: Long,
  override val templateAccessor: TemplateAccessor?,
  components: Array<IComponent>
) : IEntity, IEntityInternal {
  private val logger = KotlinLogging.logger { }

  private val _components: MutableMap<KClass<out IComponent>, IComponent> = mutableMapOf()

  private val _sharedPlayers: MutableSet<IPlayerConnection> = mutableSetOf()
  private val _sharedPlayersMutex: Mutex = Mutex()

  override val components: Set<IComponent>
    get() = _components.values.toSet()

  init {
    components.forEach { component ->
      _components[component::class] = component
    }
  }

  override suspend fun share(connection: IPlayerConnection) {
    _sharedPlayersMutex.withLock {
      require(_sharedPlayers.add(connection)) { "Entity $id already shared to $connection" }
    }
    logger.debug { "Sharing $this to $connection" }
    connection.send(toShareCommand())
  }

  override suspend fun unshare(connection: IPlayerConnection) {
    _sharedPlayersMutex.withLock {
      requireNotNull(_sharedPlayers.remove(connection)) { "Entity $id is not shared to $connection" }
    }
    connection.send(toUnshareCommand())
  }

  override fun hasComponent(type: KClass<out IComponent>): Boolean = _components.contains(type)
  override fun getComponent(type: KClass<out IComponent>): IComponent {
    return requireNotNull(_components[type]) { "Entity $id does not have component $type" }
  }

  override suspend fun addComponent(component: IComponent) = addComponent(component, excluded = null)
  override suspend fun removeComponent(type: KClass<out IComponent>) = removeComponent(type, excluded = null)

  override suspend fun addComponent(component: IComponent, excluded: IPlayerConnection?) {
    synchronized(_components) {
      val type = component::class

      require(!_components.contains(type)) { "Entity $id already has component $type" }
      _components[type] = component
    }

    logger.debug { "Add component $component to $this" }
    _sharedPlayersMutex.withLock {
      _sharedPlayers.forEach { player ->
        if(player == excluded) return@forEach
        player.send(ComponentAddCommand(entity = this, component))
      }
    }
  }

  override suspend fun removeComponent(type: KClass<out IComponent>, excluded: IPlayerConnection?) {
    requireNotNull(_components.remove(type)) { "Entity $id does not have component $type" }

    _sharedPlayersMutex.withLock {
      _sharedPlayers.forEach { player ->
        if(player == excluded) return@forEach
        player.send(ComponentRemoveCommand(entity = this, type))
      }
    }
  }

  override fun toString(): String {
    return "${this::class.simpleName}(id=$id, templateAccessor=$templateAccessor, components=$components)"
  }
}
