package jp.assasans.araumi.tx.server.extensions

import kotlin.reflect.KClass
import kotlin.reflect.full.isSubclassOf

fun <T : Any, R : Any> List<T>.asListOf(type: KClass<R>, check: Boolean): List<R> {
  if(check) {
    for(item in this) {
      if(!item::class.isSubclassOf(type)) throw IllegalArgumentException("${item::class} is not a subclass of $type")
    }
  }

  @Suppress("UNCHECKED_CAST")
  return this as List<R>
}

inline fun <T : Any, reified R : Any> List<T>.asListOf(check: Boolean): List<R> = asListOf(R::class, check)
