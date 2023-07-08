package jp.assasans.araumi.tx.server.ecs.events.payment

import jp.assasans.araumi.tx.server.ecs.PromoCodeCheckResult
import jp.assasans.araumi.tx.server.ecs.events.IEvent
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1490937016798)
data class PromoCodeCheckResultEvent(
  val code: String,
  val result: PromoCodeCheckResult
) : IEvent
