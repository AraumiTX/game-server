package jp.assasans.araumi.tx.server.ecs.entrance.validation

import jp.assasans.araumi.tx.server.ecs.IEvent
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(635906273700499964)
data class EmailVacantEvent(
  val email: String
) : IEvent
