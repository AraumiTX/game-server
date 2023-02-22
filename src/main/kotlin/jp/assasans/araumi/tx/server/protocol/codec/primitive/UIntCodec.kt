package jp.assasans.araumi.tx.server.protocol.codec.primitive

import jp.assasans.araumi.tx.server.network.ProtocolBuffer
import jp.assasans.araumi.tx.server.protocol.codec.Codec

class UIntCodec : Codec<UInt>() {
  override suspend fun encode(buffer: ProtocolBuffer, value: UInt) = buffer.writer.writeInt(value.toInt())
  override suspend fun decode(buffer: ProtocolBuffer): UInt = buffer.reader.readInt().toUInt()
}
