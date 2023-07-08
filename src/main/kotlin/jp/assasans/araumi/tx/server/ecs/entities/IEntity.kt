package jp.assasans.araumi.tx.server.ecs.entities

import kotlin.reflect.KClass
import jp.assasans.araumi.tx.server.ecs.components.IComponent
import jp.assasans.araumi.tx.server.ecs.entities.templates.TemplateAccessor
import jp.assasans.araumi.tx.server.ecs.events.IEvent
import jp.assasans.araumi.tx.server.extensions.singleOf
import jp.assasans.araumi.tx.server.network.IPlayerConnection

interface IEntity {
  val id: Long
  val templateAccessor: TemplateAccessor?
  val components: Set<IComponent>

  fun share(connection: IPlayerConnection)
  fun unshare(connection: IPlayerConnection)

  fun hasComponent(type: KClass<out IComponent>): Boolean
  fun getComponent(type: KClass<out IComponent>): IComponent
  fun addComponent(component: IComponent)
  fun removeComponent(type: KClass<out IComponent>)
  fun changeComponent(component: IComponent)

  fun send(event: IEvent)

  fun clone(): IEntity
}

inline fun <reified T : IComponent> IEntity.hasComponent() = hasComponent(T::class)
inline fun <reified T : IComponent> IEntity.getComponent(): T = getComponent(T::class) as T
inline fun <reified T : IComponent> IEntity.removeComponent() = removeComponent(T::class)
inline fun <reified T : IComponent> IEntity.changeComponent(block: T.() -> Unit) =
  changeComponent(getComponent<T>().apply(block))

inline fun <reified T : IComponent> Array<IEntity>.with(): T = asIterable().singleOf()

interface IEntityInternal {
  fun addComponent(component: IComponent, excluded: IPlayerConnection? = null)
  fun removeComponent(type: KClass<out IComponent>, excluded: IPlayerConnection? = null)
  fun changeComponent(component: IComponent, excluded: IPlayerConnection? = null)
}
