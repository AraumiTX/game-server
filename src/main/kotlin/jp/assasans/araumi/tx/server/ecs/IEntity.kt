package jp.assasans.araumi.tx.server.ecs

import kotlin.reflect.KClass
import jp.assasans.araumi.tx.server.extensions.singleOf
import jp.assasans.araumi.tx.server.network.IPlayerConnection

interface IEntity {
  val id: Long
  val templateAccessor: TemplateAccessor?

  val components: Set<IComponent>

  suspend fun share(connection: IPlayerConnection)
  suspend fun unshare(connection: IPlayerConnection)

  fun hasComponent(type: KClass<out IComponent>): Boolean
  fun getComponent(type: KClass<out IComponent>): IComponent
  suspend fun addComponent(component: IComponent)
  suspend fun removeComponent(type: KClass<out IComponent>)
}

inline fun <reified T : IComponent> IEntity.hasComponent() = hasComponent(T::class)
inline fun <reified T : IComponent> IEntity.getComponent() = getComponent(T::class)
suspend inline fun <reified T : IComponent> IEntity.removeComponent() = removeComponent(T::class)

inline fun <reified T : IComponent> Array<IEntity>.with(): T = asIterable().singleOf()

interface IEntityInternal {
  suspend fun addComponent(component: IComponent, excluded: IPlayerConnection? = null)
  suspend fun removeComponent(type: KClass<out IComponent>, excluded: IPlayerConnection? = null)
}
