package jp.assasans.araumi.tx.server.ecs.components.entrance

import jp.assasans.araumi.tx.server.ecs.components.IComponent
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1439792100478)
data class SessionSecurityPublicComponent(
  val publicKey: String
) : IComponent
