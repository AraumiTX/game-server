package jp.assasans.araumi.tx.server.protocol.codec.container

import jp.assasans.araumi.tx.server.network.ProtocolBuffer
import jp.assasans.araumi.tx.server.protocol.IProtocol
import jp.assasans.araumi.tx.server.protocol.codec.Codec
import jp.assasans.araumi.tx.server.protocol.codec.ICodec

class OptionalCodec<T>(val codec: ICodec<T>) : Codec<T?>() {
  override fun init(protocol: IProtocol) {
    super.init(protocol)
    codec.init(protocol)
  }

  override suspend fun encode(buffer: ProtocolBuffer, value: T?) {
    buffer.optionalMap.add(value == null)
    if(value == null) return

    codec.encode(buffer, value)
  }

  override suspend fun decode(buffer: ProtocolBuffer): T? {
    if(buffer.optionalMap.get()) return null
    return codec.decode(buffer)
  }
}
