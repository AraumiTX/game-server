package jp.assasans.araumi.tx.server.protocol.codec.complex

import jp.assasans.araumi.tx.server.ecs.TemplateAccessor
import jp.assasans.araumi.tx.server.network.ProtocolBuffer
import jp.assasans.araumi.tx.server.protocol.codec.Codec
import jp.assasans.araumi.tx.server.protocol.codec.info.TypeCodecInfo
import jp.assasans.araumi.tx.server.protocol.getCodec

class TemplateAccessorCodec : Codec<TemplateAccessor>() {
  override suspend fun encode(buffer: ProtocolBuffer, value: TemplateAccessor) {
    protocol.getCodec<Long>(TypeCodecInfo(Long::class)).encode(buffer, value.id)
    protocol.getCodec<String?>(TypeCodecInfo(String::class, true)).encode(buffer, value.configPath)
  }

  override suspend fun decode(buffer: ProtocolBuffer): TemplateAccessor {
    return TemplateAccessor(
      protocol.getCodec<Long>(TypeCodecInfo(Long::class)).decode(buffer),
      protocol.getCodec<String?>(TypeCodecInfo(String::class, true)).decode(buffer)
    )
  }
}
