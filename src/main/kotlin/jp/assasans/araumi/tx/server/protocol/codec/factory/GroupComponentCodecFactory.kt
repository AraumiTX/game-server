package jp.assasans.araumi.tx.server.protocol.codec.factory

import kotlin.reflect.full.isSubclassOf
import jp.assasans.araumi.tx.server.ecs.GroupComponent
import jp.assasans.araumi.tx.server.extensions.kotlinClass
import jp.assasans.araumi.tx.server.protocol.Protocol
import jp.assasans.araumi.tx.server.protocol.codec.Codec
import jp.assasans.araumi.tx.server.protocol.codec.complex.GroupComponentCodec
import jp.assasans.araumi.tx.server.protocol.codec.info.ICodecInfo
import jp.assasans.araumi.tx.server.protocol.codec.info.TypeCodecInfo

class GroupComponentCodecFactory : ICodecFactory {
  override fun create(protocol: Protocol, info: ICodecInfo): Codec<*>? {
    if(info !is TypeCodecInfo || !info.type.kotlinClass.isSubclassOf(GroupComponent::class)) return null

    return GroupComponentCodec()
  }
}
