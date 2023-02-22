package jp.assasans.araumi.tx.server.protocol.codec.factory

import jp.assasans.araumi.tx.server.protocol.Protocol
import jp.assasans.araumi.tx.server.protocol.codec.Codec
import jp.assasans.araumi.tx.server.protocol.codec.info.ICodecInfo

interface ICodecFactory {
  fun create(protocol: Protocol, info: ICodecInfo): Codec<*>?
}
