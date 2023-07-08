package jp.assasans.araumi.tx.server.ecs.components.user

import jp.assasans.araumi.tx.server.ecs.components.IComponent
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1457515023113)
data class ConfirmedUserEmailComponent(
  val email: String,
  val subscribed: Boolean
) : IComponent
