package jp.assasans.araumi.tx.server.ecs.components.user

import jp.assasans.araumi.tx.server.ecs.components.group.GroupComponent
import jp.assasans.araumi.tx.server.ecs.entities.IEntity
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(7453043498913563889)
class UserGroupComponent(key: Long) : GroupComponent(key) {
  constructor(entity: IEntity) : this(entity.id)
}
