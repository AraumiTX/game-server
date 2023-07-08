package jp.assasans.araumi.tx.server.protocol.codec.factory

import kotlin.reflect.KClass
import jp.assasans.araumi.tx.server.extensions.kotlinClass
import jp.assasans.araumi.tx.server.protocol.Protocol
import jp.assasans.araumi.tx.server.protocol.codec.Codec
import jp.assasans.araumi.tx.server.protocol.codec.container.VariedStructCodec
import jp.assasans.araumi.tx.server.protocol.codec.container.VariedTypeCodec
import jp.assasans.araumi.tx.server.protocol.codec.info.ICodecInfo
import jp.assasans.araumi.tx.server.protocol.codec.info.TypeCodecInfo

class VariedCodecFactory : ICodecFactory {
  override fun create(protocol: Protocol, info: ICodecInfo): Codec<*>? {
    if(info !is TypeCodecInfo || !info.varied) return null

    return if(info.type.kotlinClass == KClass::class) VariedTypeCodec()
    else VariedStructCodec()
  }
}
