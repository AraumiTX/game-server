package jp.assasans.araumi.tx.server.ecs

abstract class GroupComponent(
  val key: Long
) : IComponent {
  constructor(entity: IEntity) : this(entity.id)
}
