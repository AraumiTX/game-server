package jp.assasans.araumi.tx.server.ecs.components.entrance

import jp.assasans.araumi.tx.server.ecs.components.IComponent
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1453796862447)
data class ClientLocaleComponent(
  val localeCode: String
) : IComponent
