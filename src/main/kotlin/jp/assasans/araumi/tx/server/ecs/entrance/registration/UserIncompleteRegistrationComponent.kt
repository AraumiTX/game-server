package jp.assasans.araumi.tx.server.ecs.entrance.registration

import jp.assasans.araumi.tx.server.ecs.IComponent
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1482675132842)
data class UserIncompleteRegistrationComponent(
  val firstBattleDone: Boolean
) : IComponent
