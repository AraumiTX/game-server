package jp.assasans.araumi.tx.server.ecs.components.group

import jp.assasans.araumi.tx.server.ecs.components.IComponent
import jp.assasans.araumi.tx.server.ecs.entities.IEntity

abstract class GroupComponent(
  val key: Long
) : IComponent {
  constructor(entity: IEntity) : this(entity.id)
}
