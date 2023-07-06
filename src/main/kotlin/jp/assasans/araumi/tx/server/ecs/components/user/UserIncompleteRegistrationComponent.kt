package jp.assasans.araumi.tx.server.ecs.components.user

import jp.assasans.araumi.tx.server.ecs.components.IComponent
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1482675132842)
data class UserIncompleteRegistrationComponent(
  val firstBattleDone: Boolean
) : IComponent
