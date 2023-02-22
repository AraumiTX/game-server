package jp.assasans.araumi.tx.server.protocol.codec.info

import kotlin.reflect.KClass
import kotlin.reflect.KType
import kotlin.reflect.full.createType

data class TypeCodecInfo(
  override val type: KType,
  override val nullable: Boolean = false,
  override val varied: Boolean = false,
  override val annotations: Set<Annotation> = setOf()
) : ITypeCodecInfo {
  constructor(
    type: KClass<*>,
    nullable: Boolean = false,
    varied: Boolean = false,
    annotations: Set<Annotation> = setOf()
  ) : this(type.createType(), nullable, varied, annotations)
}
