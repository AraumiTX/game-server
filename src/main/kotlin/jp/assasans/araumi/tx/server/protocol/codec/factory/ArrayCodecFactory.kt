package jp.assasans.araumi.tx.server.protocol.codec.factory

import jp.assasans.araumi.tx.server.extensions.kotlinClass
import jp.assasans.araumi.tx.server.extensions.singleOfOrNull
import jp.assasans.araumi.tx.server.protocol.Protocol
import jp.assasans.araumi.tx.server.protocol.ProtocolCollection
import jp.assasans.araumi.tx.server.protocol.codec.Codec
import jp.assasans.araumi.tx.server.protocol.codec.container.ArrayCodec
import jp.assasans.araumi.tx.server.protocol.codec.info.ICodecInfo
import jp.assasans.araumi.tx.server.protocol.codec.info.ITypeCodecInfo
import jp.assasans.araumi.tx.server.protocol.codec.info.TypeCodecInfo

class ArrayCodecFactory : ICodecFactory {
  override fun create(protocol: Protocol, info: ICodecInfo): Codec<*>? {
    if(info !is ITypeCodecInfo || !info.type.kotlinClass.java.isArray) return null

    val annotation = info.annotations.singleOfOrNull() ?: ProtocolCollection.Default
    return ArrayCodec<Any>(TypeCodecInfo(
      type = info.type.kotlinClass.java.componentType.kotlin,
      annotation.nullable,
      annotation.varied
    ))
  }
}
