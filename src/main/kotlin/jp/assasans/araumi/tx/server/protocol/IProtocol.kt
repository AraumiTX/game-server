package jp.assasans.araumi.tx.server.protocol

import kotlin.reflect.KClass
import jp.assasans.araumi.tx.server.extensions.cast
import jp.assasans.araumi.tx.server.protocol.codec.ICodec
import jp.assasans.araumi.tx.server.protocol.codec.info.ICodecInfo

interface IProtocol {
  fun getCodecRaw(info: ICodecInfo): ICodec<*>

  fun getTypeById(id: Long): KClass<*>
}

@Suppress("NOTHING_TO_INLINE")
inline fun <T> IProtocol.getCodec(info: ICodecInfo): ICodec<T> = getCodecRaw(info).cast()
