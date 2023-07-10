package jp.assasans.araumi.tx.server.ecs.components.item.preset

import jp.assasans.araumi.tx.server.ecs.components.IComponent
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1493974995307)
data class PresetNameComponent(
  val name: String
) : IComponent
