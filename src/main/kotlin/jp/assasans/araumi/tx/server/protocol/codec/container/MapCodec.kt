package jp.assasans.araumi.tx.server.protocol.codec.container

import jp.assasans.araumi.tx.server.network.ProtocolBuffer
import jp.assasans.araumi.tx.server.protocol.codec.Codec
import jp.assasans.araumi.tx.server.protocol.codec.VarIntCodecHelper
import jp.assasans.araumi.tx.server.protocol.codec.info.ICodecInfo
import jp.assasans.araumi.tx.server.protocol.getCodec

class MapCodec<K, V>(
  val keyCodecInfo: ICodecInfo,
  val valueCodecInfo: ICodecInfo
) : Codec<Map<K, V>>() {
  override suspend fun encode(buffer: ProtocolBuffer, value: Map<K, V>) {
    val keyCodec = protocol.getCodec<K>(keyCodecInfo)
    val valueCodec = protocol.getCodec<V>(valueCodecInfo)

    VarIntCodecHelper.encode(buffer.writer, value.size)
    value.forEach { (key, value) ->
      keyCodec.encode(buffer, key)
      valueCodec.encode(buffer, value)
    }
  }

  override suspend fun decode(buffer: ProtocolBuffer): Map<K, V> {
    val keyCodec = protocol.getCodec<K>(keyCodecInfo)
    val valueCodec = protocol.getCodec<V>(valueCodecInfo)

    val count = VarIntCodecHelper.decode(buffer.reader)
    val set = HashMap<K, V>(count)
    for(index in 0 until count) {
      val key = keyCodec.decode(buffer)
      val value = valueCodec.decode(buffer)

      set[key] = value
    }
    return set
  }
}
