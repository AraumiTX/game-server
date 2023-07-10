package jp.assasans.araumi.tx.server.ecs.components.item

import jp.assasans.araumi.tx.server.ecs.components.IComponent
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1479807693001)
data class UserItemCounterComponent(
  val count: Long
) : IComponent
