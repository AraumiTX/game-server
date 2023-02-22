package jp.assasans.araumi.tx.server.protocol.codec.primitive

import jp.assasans.araumi.tx.server.network.ProtocolBuffer
import jp.assasans.araumi.tx.server.protocol.codec.Codec

class ShortCodec : Codec<Short>() {
  override suspend fun encode(buffer: ProtocolBuffer, value: Short) = buffer.writer.writeShort(value)
  override suspend fun decode(buffer: ProtocolBuffer): Short = buffer.reader.readShort()
}
