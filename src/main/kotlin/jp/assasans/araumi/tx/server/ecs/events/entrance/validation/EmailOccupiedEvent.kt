package jp.assasans.araumi.tx.server.ecs.events.entrance.validation

import jp.assasans.araumi.tx.server.ecs.events.IEvent
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(635906273457089964)
data class EmailOccupiedEvent(
  val email: String
) : IEvent
