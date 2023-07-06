package jp.assasans.araumi.tx.server.ecs.events.entrance.validation

import jp.assasans.araumi.tx.server.ecs.events.IEvent
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(635906273700499964)
data class EmailVacantEvent(
  val email: String
) : IEvent
