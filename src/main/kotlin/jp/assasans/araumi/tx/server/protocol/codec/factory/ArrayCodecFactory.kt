package jp.assasans.araumi.tx.server.protocol.codec.factory

import jp.assasans.araumi.tx.server.extensions.kotlinClass
import jp.assasans.araumi.tx.server.extensions.singleOfOrNull
import jp.assasans.araumi.tx.server.protocol.Protocol
import jp.assasans.araumi.tx.server.protocol.ProtocolCollection
import jp.assasans.araumi.tx.server.protocol.codec.Codec
import jp.assasans.araumi.tx.server.protocol.codec.container.array.ArrayCodec
import jp.assasans.araumi.tx.server.protocol.codec.info.ICodecInfo
import jp.assasans.araumi.tx.server.protocol.codec.info.ITypeCodecInfo
import jp.assasans.araumi.tx.server.protocol.codec.info.TypeCodecInfo

class ArrayCodecFactory : ICodecFactory {
  override fun create(protocol: Protocol, info: ICodecInfo): Codec<*>? {
    if(info !is ITypeCodecInfo || !info.type.kotlinClass.java.isArray) return null

    val type = info.type.kotlinClass.java.componentType
    if(type.isPrimitive) error("No primitive array codec available for ${type.kotlin}")

    val annotation = info.annotations.singleOfOrNull() ?: ProtocolCollection.Default
    return ArrayCodec<Any>(
      TypeCodecInfo(
        type = type.kotlin,
        annotation.nullable,
        annotation.varied
      )
    )
  }
}
