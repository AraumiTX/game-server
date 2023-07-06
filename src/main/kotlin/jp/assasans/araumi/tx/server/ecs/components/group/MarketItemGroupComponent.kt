package jp.assasans.araumi.tx.server.ecs.components.group

import jp.assasans.araumi.tx.server.ecs.entities.IEntity
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(63290793489633843)
class MarketItemGroupComponent(key: Long) : GroupComponent(key) {
  constructor(entity: IEntity) : this(entity.id)
}
