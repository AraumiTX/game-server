package jp.assasans.araumi.tx.server.ecs.events.payment

import jp.assasans.araumi.tx.server.ecs.PaymentStatisticsAction
import jp.assasans.araumi.tx.server.ecs.events.IEvent
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1471252962981)
data class PaymentStatisticsEvent(
  val action: PaymentStatisticsAction,
  val item: Long,
  val method: Long,
  val screen: String
) : IEvent
