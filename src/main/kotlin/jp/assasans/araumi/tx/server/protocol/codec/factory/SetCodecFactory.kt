package jp.assasans.araumi.tx.server.protocol.codec.factory

import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.isSubclassOf
import jp.assasans.araumi.tx.server.extensions.kotlinClass
import jp.assasans.araumi.tx.server.protocol.Protocol
import jp.assasans.araumi.tx.server.protocol.ProtocolCollection
import jp.assasans.araumi.tx.server.protocol.codec.Codec
import jp.assasans.araumi.tx.server.protocol.codec.container.SetCodec
import jp.assasans.araumi.tx.server.protocol.codec.info.ICodecInfo
import jp.assasans.araumi.tx.server.protocol.codec.info.ITypeCodecInfo
import jp.assasans.araumi.tx.server.protocol.codec.info.TypeCodecInfo

class SetCodecFactory : ICodecFactory {
  override fun create(protocol: Protocol, info: ICodecInfo): Codec<*>? {
    if(info !is ITypeCodecInfo || !info.type.kotlinClass.isSubclassOf(Set::class)) return null

    val annotation = info.type.findAnnotation() ?: ProtocolCollection.Default
    return SetCodec<Any>(TypeCodecInfo(
      type = requireNotNull(info.type.arguments.single().type) { "Invalid Set<T> generic argument" },
      annotation.nullable,
      annotation.varied
    ))
  }
}
