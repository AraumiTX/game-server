package jp.assasans.araumi.tx.server.protocol.codec.complex

import jp.assasans.araumi.tx.server.ecs.components.group.GroupComponent
import jp.assasans.araumi.tx.server.extensions.kotlinClass
import jp.assasans.araumi.tx.server.network.ProtocolBuffer
import jp.assasans.araumi.tx.server.protocol.codec.Codec
import jp.assasans.araumi.tx.server.protocol.codec.info.TypeCodecInfo
import jp.assasans.araumi.tx.server.protocol.getCodec
import jp.assasans.araumi.tx.server.protocol.protocolId

class GroupComponentCodec : Codec<GroupComponent>() {
  override suspend fun encode(buffer: ProtocolBuffer, value: GroupComponent) {
    protocol.getCodec<Long>(TypeCodecInfo(Long::class)).encode(buffer, value::class.protocolId.id)
    protocol.getCodec<Long>(TypeCodecInfo(Long::class)).encode(buffer, value.key)
  }

  override suspend fun decode(buffer: ProtocolBuffer): GroupComponent {
    val id = protocol.getCodec<Long>(TypeCodecInfo(Long::class)).decode(buffer)
    val type = protocol.getTypeById(id)

    val key = protocol.getCodec<Long>(TypeCodecInfo(Long::class)).decode(buffer)

    return type.constructors
      .single { it.parameters.single().type.kotlinClass == Long::class }
      .call(key) as GroupComponent
  }
}
