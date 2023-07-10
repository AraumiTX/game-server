package jp.assasans.araumi.tx.server.ecs.components.item.preset

import jp.assasans.araumi.tx.server.ecs.components.IComponent
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1502886877871)
data class PresetEquipmentComponent(
  val weaponId: Long,
  val hullId: Long
) : IComponent
