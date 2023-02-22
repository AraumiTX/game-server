@file:Suppress("NOTHING_TO_INLINE")

package jp.assasans.araumi.tx.server.extensions

import kotlin.reflect.KClass
import kotlin.reflect.full.isSubclassOf

inline fun <T : Any, R : T> T.cast(type: KClass<R>): R {
  @Suppress("UNCHECKED_CAST")
  if(this::class.isSubclassOf(type)) return this as R

  throw ClassCastException("${this::class} is not assignable to $type")
}

inline fun <T : Any, reified R : T> T.cast(): R = cast(R::class)

@JvmName("castNullable")
inline fun <T : Any, R : T> T?.cast(type: KClass<R>): R? {
  if(this == null) return null
  return cast(type)
}

@JvmName("castNullableReified")
inline fun <T : Any, reified R : T> T?.cast(): R? = cast(R::class)
