package jp.assasans.araumi.tx.server.protocol.codec.primitive

import jp.assasans.araumi.tx.server.network.ProtocolBuffer
import jp.assasans.araumi.tx.server.protocol.codec.Codec

class IntCodec : Codec<Int>() {
  override suspend fun encode(buffer: ProtocolBuffer, value: Int) = buffer.writer.writeInt(value)
  override suspend fun decode(buffer: ProtocolBuffer): Int = buffer.reader.readInt()
}
