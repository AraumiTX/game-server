package jp.assasans.araumi.tx.server.ecs.components.entrance

import jp.assasans.araumi.tx.server.ecs.components.IComponent
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1479820450460)
data class WebIdComponent(
  val webId: String = "",
  val utm: String = "",
  val googleAnalyticsId: String = "",
  val webIdUid: String = ""
) : IComponent
