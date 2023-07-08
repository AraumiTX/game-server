package jp.assasans.araumi.tx.server.ecs.components.user

import jp.assasans.araumi.tx.server.ecs.components.IComponent
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1482920154068)
data class UserSubscribeComponent(
  val subscribed: Boolean
) : IComponent
