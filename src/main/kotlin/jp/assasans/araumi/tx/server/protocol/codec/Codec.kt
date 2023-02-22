package jp.assasans.araumi.tx.server.protocol.codec

import jp.assasans.araumi.tx.server.protocol.IProtocol

abstract class Codec<T> : ICodec<T> {
  private var _protocol: IProtocol? = null
  override val protocol: IProtocol
    get() = checkNotNull(_protocol) { "Codec is not initialized" }

  override fun init(protocol: IProtocol) {
    _protocol = protocol
  }
}
