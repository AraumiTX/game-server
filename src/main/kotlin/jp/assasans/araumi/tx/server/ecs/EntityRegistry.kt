package jp.assasans.araumi.tx.server.ecs

import java.util.concurrent.atomic.AtomicLong
import kotlinx.datetime.Clock

class EntityRegistry : IEntityRegistry {
  private val entities: MutableMap<Long, IEntity> = mutableMapOf()

  private val baseId: Long = Clock.System.now().toEpochMilliseconds()
  private val nextId: AtomicLong = AtomicLong(baseId)

  override val freeId: Long
    get() = nextId.get()

  override fun add(entity: IEntity) {
    synchronized(entities) {
      require(!entities.contains(entity.id)) { "Entity ${entity.id} already present in registry" }
      entities[entity.id] = entity
    }
  }

  override fun get(id: Long): IEntity {
    return requireNotNull(entities[id]) { "Unknown entity $id" }
  }
}
