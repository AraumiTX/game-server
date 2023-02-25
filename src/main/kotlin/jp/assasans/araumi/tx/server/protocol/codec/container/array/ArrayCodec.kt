package jp.assasans.araumi.tx.server.protocol.codec.container.array

import jp.assasans.araumi.tx.server.extensions.kotlinClass
import jp.assasans.araumi.tx.server.network.ProtocolBuffer
import jp.assasans.araumi.tx.server.protocol.codec.Codec
import jp.assasans.araumi.tx.server.protocol.codec.VarIntCodecHelper
import jp.assasans.araumi.tx.server.protocol.codec.info.ICodecInfo
import jp.assasans.araumi.tx.server.protocol.codec.info.ITypeCodecInfo
import jp.assasans.araumi.tx.server.protocol.getCodec

class ArrayCodec<T>(
  val elementCodecInfo: ICodecInfo
) : Codec<Array<T>>() {
  override suspend fun encode(buffer: ProtocolBuffer, value: Array<T>) {
    val elementCodec = protocol.getCodec<T>(elementCodecInfo)

    VarIntCodecHelper.encode(buffer.writer, value.size)
    value.forEach { elementCodec.encode(buffer, it) }
  }

  override suspend fun decode(buffer: ProtocolBuffer): Array<T> {
    require(elementCodecInfo is ITypeCodecInfo)
    val elementCodec = protocol.getCodec<T>(elementCodecInfo)

    val count = VarIntCodecHelper.decode(buffer.reader)
    val array = java.lang.reflect.Array.newInstance(elementCodecInfo.type.kotlinClass.java, count) as Array<T>
    for(index in 0 until count) {
      array[index] = elementCodec.decode(buffer)
    }
    return array
  }
}
