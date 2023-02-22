package jp.assasans.araumi.tx.server.protocol.codec.primitive

import jp.assasans.araumi.tx.server.network.ProtocolBuffer
import jp.assasans.araumi.tx.server.protocol.codec.Codec

class ByteCodec : Codec<Byte>() {
  override suspend fun encode(buffer: ProtocolBuffer, value: Byte) = buffer.writer.writeByte(value)
  override suspend fun decode(buffer: ProtocolBuffer): Byte = buffer.reader.readByte()
}
