package jp.assasans.araumi.tx.server.ecs.events.entrance.validation

import jp.assasans.araumi.tx.server.ecs.events.IEvent
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1455866538339L)
data class EmailInvalidEvent(
  val email: String
) : IEvent
