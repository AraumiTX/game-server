package jp.assasans.araumi.tx.server.ecs.entities

interface IEntityRegistry {
  val freeId: Long

  fun add(entity: IEntity)
  fun get(id: Long): IEntity
}
