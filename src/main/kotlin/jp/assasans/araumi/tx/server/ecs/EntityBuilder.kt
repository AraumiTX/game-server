package jp.assasans.araumi.tx.server.ecs

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import jp.assasans.araumi.tx.server.extensions.inject

class EntityBuilder(override val id: Long) : IEntityBuilder, KoinComponent {
  private val entityRegistry: IEntityRegistry by inject()

  override var templateAccessor: TemplateAccessor? = null
  override val components: MutableSet<IComponent> = mutableSetOf()

  override fun build(): IEntity {
    val entity = Entity(id, templateAccessor, components.toTypedArray())
    entityRegistry.add(entity)

    return entity
  }
}

inline fun entity(block: IEntityBuilder.() -> Unit): IEntity {
  val entityRegistry: IEntityRegistry by inject()
  return EntityBuilder(entityRegistry.freeId).apply(block).build()
}
