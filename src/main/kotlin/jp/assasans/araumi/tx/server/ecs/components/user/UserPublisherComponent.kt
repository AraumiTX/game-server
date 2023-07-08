package jp.assasans.araumi.tx.server.ecs.components.user

import jp.assasans.araumi.tx.server.ecs.components.IComponent
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(32195187150433)
data class UserPublisherComponent(
  val publisher: Byte = 0 // 0 - GLOBAL, 1 - CONSALA (for turkey)
) : IComponent
