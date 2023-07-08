package jp.assasans.araumi.tx.server.ecs

enum class PromoCodeCheckResult {
  VALID,
  NOT_FOUND,
  USED,
  EXPIRED,
  INVALID,
  OWNED
}
