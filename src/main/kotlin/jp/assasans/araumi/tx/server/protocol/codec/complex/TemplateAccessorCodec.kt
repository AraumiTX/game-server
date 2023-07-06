package jp.assasans.araumi.tx.server.protocol.codec.complex

import jp.assasans.araumi.tx.server.ecs.entities.templates.TemplateAccessor
import jp.assasans.araumi.tx.server.ecs.entities.templates.id
import jp.assasans.araumi.tx.server.network.ProtocolBuffer
import jp.assasans.araumi.tx.server.protocol.codec.Codec
import jp.assasans.araumi.tx.server.protocol.codec.info.TypeCodecInfo
import jp.assasans.araumi.tx.server.protocol.getCodec

class TemplateAccessorCodec : Codec<TemplateAccessor>() {
  override suspend fun encode(buffer: ProtocolBuffer, value: TemplateAccessor) {
    protocol.getCodec<Long>(TypeCodecInfo(Long::class)).encode(buffer, value.template::class.id)
    protocol.getCodec<String?>(TypeCodecInfo(String::class, true)).encode(buffer, value.configPath)
  }

  override suspend fun decode(buffer: ProtocolBuffer): TemplateAccessor {
    TODO("Not yet implemented")
  }
}
