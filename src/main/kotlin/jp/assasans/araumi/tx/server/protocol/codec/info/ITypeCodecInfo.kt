package jp.assasans.araumi.tx.server.protocol.codec.info

import kotlin.reflect.KType

interface ITypeCodecInfo : ICodecInfo {
  val type: KType
  val nullable: Boolean
  val varied: Boolean
  val annotations: Set<Annotation>
}
