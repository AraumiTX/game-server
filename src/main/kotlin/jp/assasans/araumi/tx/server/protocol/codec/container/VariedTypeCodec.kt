package jp.assasans.araumi.tx.server.protocol.codec.container

import kotlin.reflect.KClass
import jp.assasans.araumi.tx.server.network.ProtocolBuffer
import jp.assasans.araumi.tx.server.protocol.codec.Codec
import jp.assasans.araumi.tx.server.protocol.codec.info.TypeCodecInfo
import jp.assasans.araumi.tx.server.protocol.getCodec
import jp.assasans.araumi.tx.server.protocol.protocolId

class VariedTypeCodec : Codec<KClass<*>>() {
  override suspend fun encode(buffer: ProtocolBuffer, value: KClass<*>) {
    protocol.getCodec<Long>(TypeCodecInfo(Long::class)).encode(buffer, value.protocolId.id)
  }

  override suspend fun decode(buffer: ProtocolBuffer): KClass<*> {
    val id = protocol.getCodec<Long>(TypeCodecInfo(Long::class)).decode(buffer)
    return protocol.getTypeById(id)
  }
}
