package jp.assasans.araumi.tx.server.ecs

enum class PaymentStatisticsAction {
  OPEN_PAYMENT,
  COUNTRY_SELECT,
  ITEM_SELECT,
  MODE_SELECT,
  PROCEED,
  CLOSE_PAYMENT,
  OPEN_EXCHANGE,
  PAYMENT_ERROR,
  CONFIRMED_ONE_TIME_OFFER
}
