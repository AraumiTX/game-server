package jp.assasans.araumi.tx.server.protocol.codec.primitive

import jp.assasans.araumi.tx.server.network.ProtocolBuffer
import jp.assasans.araumi.tx.server.protocol.codec.Codec

class LongCodec : Codec<Long>() {
  override suspend fun encode(buffer: ProtocolBuffer, value: Long) = buffer.writer.writeLong(value)
  override suspend fun decode(buffer: ProtocolBuffer): Long = buffer.reader.readLong()
}
