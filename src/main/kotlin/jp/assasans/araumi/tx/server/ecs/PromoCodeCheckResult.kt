package jp.assasans.araumi.tx.server.ecs

import jp.assasans.araumi.tx.server.protocol.ProtocolType
import jp.assasans.araumi.tx.server.protocol.codec.factory.IProtocolEnum

@ProtocolType(Byte::class)
enum class PromoCodeCheckResult(
  override val value: Byte
) : IProtocolEnum<Byte> {
  VALID(0),
  NOT_FOUND(1),
  USED(2),
  EXPIRED(3),
  INVALID(4),
  OWNED(5)
}
