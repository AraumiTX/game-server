package jp.assasans.araumi.tx.server.protocol.codec.container

import jp.assasans.araumi.tx.server.network.ProtocolBuffer
import jp.assasans.araumi.tx.server.protocol.codec.Codec
import jp.assasans.araumi.tx.server.protocol.codec.VarIntCodecHelper
import jp.assasans.araumi.tx.server.protocol.codec.info.ICodecInfo
import jp.assasans.araumi.tx.server.protocol.getCodec

class ListCodec<T>(
  val elementCodecInfo: ICodecInfo
) : Codec<List<T>>() {
  override suspend fun encode(buffer: ProtocolBuffer, value: List<T>) {
    val elementCodec = protocol.getCodec<T>(elementCodecInfo)

    VarIntCodecHelper.encode(buffer.writer, value.size)
    value.forEach { elementCodec.encode(buffer, it) }
  }

  override suspend fun decode(buffer: ProtocolBuffer): List<T> {
    val elementCodec = protocol.getCodec<T>(elementCodecInfo)

    val count = VarIntCodecHelper.decode(buffer.reader)
    val list = ArrayList<T>(count)
    for(index in 0 until count) {
      list.add(elementCodec.decode(buffer))
    }
    return list
  }
}
