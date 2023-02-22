package jp.assasans.araumi.tx.server.protocol.codec.container

import kotlin.reflect.KClass
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.KProperty1
import kotlin.reflect.jvm.javaField
import mu.KotlinLogging
import jp.assasans.araumi.tx.server.extensions.UnsafeUtils
import jp.assasans.araumi.tx.server.network.ProtocolBuffer
import jp.assasans.araumi.tx.server.protocol.codec.Codec
import jp.assasans.araumi.tx.server.protocol.codec.info.ICodecInfo
import jp.assasans.araumi.tx.server.protocol.getCodec

class StructCodec<T : Any>(
  val type: KClass<T>,
  val properties: List<PropertyRequest>
) : Codec<T>() {
  private val logger = KotlinLogging.logger { }

  override suspend fun encode(buffer: ProtocolBuffer, value: T) {
    properties.forEach { property ->
      try {
        val codec = protocol.getCodec<Any?>(property.info)
        val item = (property.property as KProperty1<T, *>).get(value)

        codec.encode(buffer, item)
      } catch(exception: Exception) {
        throw IllegalStateException("While encoding property ${type.simpleName}.${property.property.name}", exception)
      }
    }
  }

  override suspend fun decode(buffer: ProtocolBuffer): T {
    val value = UnsafeUtils.get().allocateInstance(type.java) as T
    properties.forEach { property ->
      try {
        val codec = protocol.getCodec<Any?>(property.info)
        val item = codec.decode(buffer)

        val javaField = property.property.javaField
        if(property.property is KMutableProperty1) {
          (property.property as KMutableProperty1<T, Any?>).set(value, item)
        } else if(javaField != null) {
          javaField.isAccessible = true
          javaField.set(value, item)
        } else {
          throw IllegalStateException("Failed to set property value: $property")
        }
      } catch(exception: Exception) {
        throw IllegalStateException("While decoding property ${type.simpleName}.${property.property.name}", exception)
      }
    }

    return value
  }
}

data class PropertyRequest(
  val property: KProperty1<*, *>,
  val info: ICodecInfo
)
