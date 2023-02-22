package jp.assasans.araumi.tx.server.protocol.command

import jp.assasans.araumi.tx.server.protocol.ProtocolType
import jp.assasans.araumi.tx.server.protocol.codec.factory.IProtocolEnum

@ProtocolType(Byte::class)
enum class CommandCode(override val value: Byte) : IProtocolEnum<Byte> {
  SendEvent(1),
  EntityShare(2),
  EntityUnshare(3),
  ComponentAdd(4),
  ComponentRemove(5),
  ComponentChange(6),
  InitTime(7),
  Close(9)
}
