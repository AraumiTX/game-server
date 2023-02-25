package jp.assasans.araumi.tx.server.ecs.user

import jp.assasans.araumi.tx.server.ecs.GroupComponent
import jp.assasans.araumi.tx.server.ecs.IEntity
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(7453043498913563889)
class UserGroupComponent(key: Long) : GroupComponent(key) {
  constructor(entity: IEntity) : this(entity.id)
}
