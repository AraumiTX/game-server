package jp.assasans.araumi.tx.server.protocol.codec.primitive

import jp.assasans.araumi.tx.server.extensions.readNBytes
import jp.assasans.araumi.tx.server.network.ProtocolBuffer
import jp.assasans.araumi.tx.server.protocol.codec.Codec
import jp.assasans.araumi.tx.server.protocol.codec.VarIntCodecHelper

class StringCodec : Codec<String>() {
  override suspend fun encode(buffer: ProtocolBuffer, value: String) {
    val bytes = value.toByteArray()
    VarIntCodecHelper.encode(buffer.writer, bytes.size)
    buffer.writer.writeFully(bytes, 0, bytes.size)
  }

  override suspend fun decode(buffer: ProtocolBuffer): String {
    val count = VarIntCodecHelper.decode(buffer.reader)
    return buffer.reader.readNBytes(count).decodeToString()
  }
}
