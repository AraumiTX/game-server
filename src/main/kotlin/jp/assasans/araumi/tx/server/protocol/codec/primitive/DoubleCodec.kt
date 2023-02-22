package jp.assasans.araumi.tx.server.protocol.codec.primitive

import jp.assasans.araumi.tx.server.network.ProtocolBuffer
import jp.assasans.araumi.tx.server.protocol.codec.Codec

class DoubleCodec : Codec<Double>() {
  override suspend fun encode(buffer: ProtocolBuffer, value: Double) = buffer.writer.writeDouble(value)
  override suspend fun decode(buffer: ProtocolBuffer): Double = buffer.reader.readDouble()
}
