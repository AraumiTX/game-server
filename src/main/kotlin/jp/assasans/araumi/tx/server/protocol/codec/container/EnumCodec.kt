package jp.assasans.araumi.tx.server.protocol.codec.container

import kotlin.reflect.KClass
import kotlin.reflect.KType
import kotlin.reflect.full.staticFunctions
import mu.KotlinLogging
import jp.assasans.araumi.tx.server.network.ProtocolBuffer
import jp.assasans.araumi.tx.server.protocol.codec.Codec
import jp.assasans.araumi.tx.server.protocol.codec.factory.IProtocolEnum
import jp.assasans.araumi.tx.server.protocol.codec.info.TypeCodecInfo
import jp.assasans.araumi.tx.server.protocol.getCodec

class EnumCodec<T : IProtocolEnum<V>, V : Any>(
  val enumType: KClass<T>,
  val valueType: KType
) : Codec<T>() {
  private val logger = KotlinLogging.logger { }

  private val values = enumType.staticFunctions.single { it.name == "values" }.call() as Array<T>
  private val map = values.associateBy { it.value }

  override suspend fun encode(buffer: ProtocolBuffer, value: T) {
    val codec = protocol.getCodec<V>(TypeCodecInfo(valueType))
    codec.encode(buffer, value.value)
  }

  override suspend fun decode(buffer: ProtocolBuffer): T {
    val codec = protocol.getCodec<V>(TypeCodecInfo(valueType))
    val value = codec.decode(buffer)
    return map[value] ?: throw IllegalArgumentException("Unknown ${enumType.simpleName} value: $value")
  }
}
