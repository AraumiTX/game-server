package jp.assasans.araumi.tx.server.ecs.entities.templates

import kotlin.reflect.KClass
import kotlin.reflect.full.findAnnotation
import jp.assasans.araumi.tx.server.ecs.entities.*
import jp.assasans.araumi.tx.server.extensions.inject
import jp.assasans.araumi.tx.server.protocol.ProtocolId

interface IEntityTemplate

val KClass<out IEntityTemplate>.id: Long
  get() = requireNotNull(findAnnotation<ProtocolId>()) { "No @ProtocolId annotation on template $this" }.id

inline fun IEntityTemplate.entity(configPath: String?, block: IEntityBuilder.() -> Unit): IEntity {
  val entityRegistry: IEntityRegistry by inject()
  return EntityBuilder(entityRegistry.freeId)
    .also { it.templateAccessor(this, configPath) }
    .apply(block)
    .build()
}
