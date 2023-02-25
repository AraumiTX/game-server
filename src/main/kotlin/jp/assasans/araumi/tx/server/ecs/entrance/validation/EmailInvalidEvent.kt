package jp.assasans.araumi.tx.server.ecs.entrance.validation

import jp.assasans.araumi.tx.server.ecs.IEvent
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1455866538339L)
data class EmailInvalidEvent(
  val email: String
) : IEvent
