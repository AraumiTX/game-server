package jp.assasans.araumi.tx.server.protocol.codec.primitive

import jp.assasans.araumi.tx.server.network.ProtocolBuffer
import jp.assasans.araumi.tx.server.protocol.codec.Codec

class FloatCodec : Codec<Float>() {
  override suspend fun encode(buffer: ProtocolBuffer, value: Float) = buffer.writer.writeFloat(value)
  override suspend fun decode(buffer: ProtocolBuffer): Float = buffer.reader.readFloat()
}
