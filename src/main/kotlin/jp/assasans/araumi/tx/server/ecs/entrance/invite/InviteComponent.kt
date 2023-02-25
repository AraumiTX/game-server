package jp.assasans.araumi.tx.server.ecs.entrance.invite

import jp.assasans.araumi.tx.server.ecs.IComponent
import jp.assasans.araumi.tx.server.protocol.ProtocolId

// TODO: Changeable
@ProtocolId(1439808320725)
data class InviteComponent(
  val inviteCode: String?,
  val showScreenOnEntrance: Boolean
) : IComponent
