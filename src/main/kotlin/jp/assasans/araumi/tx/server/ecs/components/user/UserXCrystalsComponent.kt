package jp.assasans.araumi.tx.server.ecs.components.user

import jp.assasans.araumi.tx.server.ecs.components.IComponent
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1473074767785)
data class UserXCrystalsComponent(
  val money: Long
) : IComponent
