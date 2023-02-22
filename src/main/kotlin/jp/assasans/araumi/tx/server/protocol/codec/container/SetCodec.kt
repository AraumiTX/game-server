package jp.assasans.araumi.tx.server.protocol.codec.container

import jp.assasans.araumi.tx.server.network.ProtocolBuffer
import jp.assasans.araumi.tx.server.protocol.codec.Codec
import jp.assasans.araumi.tx.server.protocol.codec.VarIntCodecHelper
import jp.assasans.araumi.tx.server.protocol.codec.info.ICodecInfo
import jp.assasans.araumi.tx.server.protocol.getCodec

class SetCodec<T>(
  val elementCodecInfo: ICodecInfo
) : Codec<Set<T>>() {
  override suspend fun encode(buffer: ProtocolBuffer, value: Set<T>) {
    val elementCodec = protocol.getCodec<T>(elementCodecInfo)

    VarIntCodecHelper.encode(buffer.writer, value.size)
    value.forEach { elementCodec.encode(buffer, it) }
  }

  override suspend fun decode(buffer: ProtocolBuffer): Set<T> {
    val elementCodec = protocol.getCodec<T>(elementCodecInfo)

    val count = VarIntCodecHelper.decode(buffer.reader)
    val set = HashSet<T>(count)
    for(index in 0 until count) {
      set.add(elementCodec.decode(buffer))
    }
    return set
  }
}
