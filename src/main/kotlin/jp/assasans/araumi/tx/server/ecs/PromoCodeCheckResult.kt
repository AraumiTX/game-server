package jp.assasans.araumi.tx.server.ecs

import jp.assasans.araumi.tx.server.protocol.ProtocolType

@ProtocolType(Byte::class)
enum class PromoCodeCheckResult {
  VALID,
  NOT_FOUND,
  USED,
  EXPIRED,
  INVALID,
  OWNED
}
