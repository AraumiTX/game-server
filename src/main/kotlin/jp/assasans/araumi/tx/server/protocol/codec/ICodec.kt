package jp.assasans.araumi.tx.server.protocol.codec

import jp.assasans.araumi.tx.server.network.ProtocolBuffer
import jp.assasans.araumi.tx.server.protocol.IProtocol

interface ICodec<T> {
  val protocol: IProtocol

  fun init(protocol: IProtocol)

  suspend fun encode(buffer: ProtocolBuffer, value: T)
  suspend fun decode(buffer: ProtocolBuffer): T
}
