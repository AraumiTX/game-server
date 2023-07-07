package jp.assasans.araumi.tx.server.protocol.codec.factory

import jp.assasans.araumi.tx.server.protocol.Protocol
import jp.assasans.araumi.tx.server.protocol.codec.Codec
import jp.assasans.araumi.tx.server.protocol.codec.container.OptionalCodec
import jp.assasans.araumi.tx.server.protocol.codec.info.ICodecInfo
import jp.assasans.araumi.tx.server.protocol.codec.info.TypeCodecInfo

class OptionalCodecFactory : ICodecFactory {
  override fun create(protocol: Protocol, info: ICodecInfo): Codec<*>? {
    if(info !is TypeCodecInfo || !info.nullable) return null

    //println("Create OptionalCodec for $info -> ${protocol.getCodecRaw(info.copy(nullable = false))}")
    return OptionalCodec(protocol.getCodecRaw(info.copy(nullable = false)))
  }
}
