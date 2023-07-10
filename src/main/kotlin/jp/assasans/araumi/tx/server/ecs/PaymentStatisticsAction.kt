package jp.assasans.araumi.tx.server.ecs

import jp.assasans.araumi.tx.server.protocol.ProtocolType
import jp.assasans.araumi.tx.server.protocol.codec.factory.IProtocolEnum

@ProtocolType(Byte::class)
enum class PaymentStatisticsAction(
  override val value: Byte
) : IProtocolEnum<Byte> {
  OPEN_PAYMENT(0),
  COUNTRY_SELECT(1),
  ITEM_SELECT(2),
  MODE_SELECT(3),
  PROCEED(4),
  CLOSE_PAYMENT(5),
  OPEN_EXCHANGE(6),
  PAYMENT_ERROR(7),
  CONFIRMED_ONE_TIME_OFFER(8)
}
