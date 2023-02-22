package jp.assasans.araumi.tx.server.protocol.codec.container

import jp.assasans.araumi.tx.server.network.ProtocolBuffer
import jp.assasans.araumi.tx.server.network.unwrap
import jp.assasans.araumi.tx.server.protocol.buffer.OptionalMap
import jp.assasans.araumi.tx.server.protocol.codec.Codec
import jp.assasans.araumi.tx.server.protocol.codec.info.TypeCodecInfo
import jp.assasans.araumi.tx.server.protocol.getCodec
import jp.assasans.araumi.tx.server.protocol.protocolId

class VariedStructCodec : Codec<Any>() {
  override suspend fun encode(buffer: ProtocolBuffer, value: Any) {
    val type = value::class
    buffer.writer.writeLong(type.protocolId.id)

    protocol.getCodec<Any>(TypeCodecInfo(type)).encode(buffer, value)
  }

  override suspend fun decode(buffer: ProtocolBuffer): Any {
    val id = buffer.reader.readLong()
    val type = protocol.getTypeById(id)

    val inner = ProtocolBuffer(OptionalMap())
    check(inner.unwrap(buffer.reader))

    return protocol.getCodec<Any>(TypeCodecInfo(type)).decode(inner)
  }
}
