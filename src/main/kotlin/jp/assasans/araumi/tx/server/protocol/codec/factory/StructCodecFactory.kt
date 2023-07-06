package jp.assasans.araumi.tx.server.protocol.codec.factory

import kotlin.math.sign
import kotlin.reflect.KClass
import kotlin.reflect.KProperty
import kotlin.reflect.KProperty1
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.hasAnnotation
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.withNullability
import jp.assasans.araumi.tx.server.extensions.kotlinClass
import jp.assasans.araumi.tx.server.protocol.*
import jp.assasans.araumi.tx.server.protocol.codec.Codec
import jp.assasans.araumi.tx.server.protocol.codec.container.PropertyRequest
import jp.assasans.araumi.tx.server.protocol.codec.container.StructCodec
import jp.assasans.araumi.tx.server.protocol.codec.info.ICodecInfo
import jp.assasans.araumi.tx.server.protocol.codec.info.ITypeCodecInfo
import jp.assasans.araumi.tx.server.protocol.codec.info.TypeCodecInfo

class StructCodecFactory : ICodecFactory {
  override fun create(protocol: Protocol, info: ICodecInfo): Codec<*>? {
    if(info !is ITypeCodecInfo) return null

    val properties = getSortedProperties(info.type.kotlinClass).map { property ->
      PropertyRequest(
        property, TypeCodecInfo(
          type = property.returnType.withNullability(false),
          nullable = property.returnType.isMarkedNullable,
          varied = property.hasAnnotation<ProtocolVaried>(),
          annotations = property.annotations.filter { it is ProtocolCollection }.toSet()
        )
      )
    }

    return StructCodec(info.type.kotlinClass, properties)
  }

  private fun getSortedProperties(type: KClass<*>): List<KProperty1<*, *>> {
    val properties = type.memberProperties.filterNot { it.hasAnnotation<ProtocolIgnore>() }
    return properties.sortedWith { a, b ->
      val sort = (getPositionOverride(a) - getPositionOverride(b)).sign // Compare by [@ProtocolPosition]
      if(sort == 0) getNameOverride(a).compareTo(getNameOverride(b)) // Compare by name or [@ProtocolName]
      else sort
    }
  }

  private fun getNameOverride(property: KProperty<*>): String {
    property.findAnnotation<ProtocolName>()?.let { return it.name }
    return property.name
  }

  private fun getPositionOverride(property: KProperty<*>): Int {
    property.findAnnotation<ProtocolPosition>()?.let { return it.position }
    return Int.MAX_VALUE
  }
}
