package jp.assasans.araumi.tx.server.ecs.entities

import jp.assasans.araumi.tx.server.ecs.components.IComponent
import jp.assasans.araumi.tx.server.ecs.entities.templates.TemplateAccessor
import jp.assasans.araumi.tx.server.ecs.events.IEvent
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import jp.assasans.araumi.tx.server.protocol.command.ComponentAddCommand
import jp.assasans.araumi.tx.server.protocol.command.ComponentChangeCommand
import jp.assasans.araumi.tx.server.protocol.command.ComponentRemoveCommand
import jp.assasans.araumi.tx.server.protocol.command.SendEventCommand
import jp.assasans.araumi.tx.server.protocol.toShareCommand
import jp.assasans.araumi.tx.server.protocol.toUnshareCommand
import mu.KotlinLogging
import kotlin.reflect.KClass

class Entity(
  override val id: Long,
  override val templateAccessor: TemplateAccessor?,
  components: Array<IComponent>
) : IEntity, IEntityInternal {
  private val logger = KotlinLogging.logger { }

  private val _components: MutableMap<KClass<out IComponent>, IComponent> = mutableMapOf()
  private val _sharedPlayers: MutableSet<IPlayerConnection> = mutableSetOf()

  override val components: Set<IComponent>
    get() = _components.values.toSet()

  init {
    components.forEach { component ->
      _components[component::class] = component
    }
  }

  override fun share(connection: IPlayerConnection) {
    synchronized(_sharedPlayers) {
      require(_sharedPlayers.add(connection)) { "Entity $id already shared to $connection" }
    }

    logger.debug { "Sharing $this to $connection" }
    connection.send(toShareCommand())
  }

  override fun unshare(connection: IPlayerConnection) {
    synchronized(_sharedPlayers) {
      requireNotNull(_sharedPlayers.remove(connection)) { "Entity $id is not shared to $connection" }
    }
    connection.send(toUnshareCommand())
  }

  override fun hasComponent(type: KClass<out IComponent>): Boolean {
    synchronized(_components) {
      return _components.contains(type)
    }
  }

  override fun getComponent(type: KClass<out IComponent>): IComponent {
    synchronized(_components) {
      return requireNotNull(_components[type]) { "Entity $id does not have component $type" }
    }
  }

  override fun addComponent(component: IComponent) = addComponent(component, excluded = null)
  override fun removeComponent(type: KClass<out IComponent>) = removeComponent(type, excluded = null)
  override fun changeComponent(component: IComponent) = changeComponent(component, excluded = null)

  override fun addComponent(component: IComponent, excluded: IPlayerConnection?) {
    val type = component::class

    synchronized(_components) {
      require(!_components.contains(type)) { "Entity $id already has component $type" }
      _components[type] = component
    }

    logger.debug { "Add component $component to $this" }
    synchronized(_sharedPlayers) {
      _sharedPlayers.forEach { player ->
        if(player == excluded) return@forEach
        player.send(ComponentAddCommand(entity = this, component))
      }
    }
  }

  override fun removeComponent(type: KClass<out IComponent>, excluded: IPlayerConnection?) {
    synchronized(_components) {
      requireNotNull(_components.remove(type)) { "Entity $id does not have component $type" }
    }

    synchronized(_sharedPlayers) {
      _sharedPlayers.forEach { player ->
        if(player == excluded) return@forEach
        player.send(ComponentRemoveCommand(entity = this, type))
      }
    }
  }

  override fun changeComponent(component: IComponent, excluded: IPlayerConnection?) {
    val type = component::class

    synchronized(_components) {
      require(_components.contains(type)) { "Entity $id does not have component $type" }
      _components[type] = component
    }

    synchronized(_sharedPlayers) {
      _sharedPlayers.forEach { player ->
        if(player == excluded) return@forEach
        player.send(ComponentChangeCommand(entity = this, component))
      }
    }
  }

  override fun send(event: IEvent) {
    synchronized(_sharedPlayers) {
      _sharedPlayers.forEach { player ->
        player.send(SendEventCommand(event, arrayOf(this)))
      }
    }
  }

  override fun clone(): IEntity {
    val templateAccessor = this.templateAccessor?.let { TemplateAccessor(it.template, it.configPath) }

    return Entity(id, templateAccessor, components.toTypedArray())
  }

  override fun toString(): String {
    return "${this::class.simpleName}(id=$id, templateAccessor=$templateAccessor, components=$components)"
  }
}
