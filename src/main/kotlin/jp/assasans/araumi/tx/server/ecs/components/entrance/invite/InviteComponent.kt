package jp.assasans.araumi.tx.server.ecs.components.entrance.invite

import jp.assasans.araumi.tx.server.ecs.components.IComponent
import jp.assasans.araumi.tx.server.protocol.ProtocolId

// TODO: Changeable
@ProtocolId(1439808320725)
data class InviteComponent(
  val inviteCode: String?,
  val showScreenOnEntrance: Boolean
) : IComponent
