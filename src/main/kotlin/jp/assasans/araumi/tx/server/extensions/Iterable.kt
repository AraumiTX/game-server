package jp.assasans.araumi.tx.server.extensions

import kotlin.reflect.KClass

inline fun <T : Any, reified I : T> Iterable<T>.singleOf(): I = single { it is I }.cast()
inline fun <T : Any, reified I : T> Iterable<T>.singleOf(predicate: (I) -> Boolean): I =
  single { it is I && predicate(it) }.cast()

inline fun <T : Any, reified I : T> Iterable<T>.singleOfOrNull(): I? = singleOrNull { it is I }?.cast()
inline fun <T : Any, reified I : T> Iterable<T>.singleOfOrNull(predicate: (I) -> Boolean): I? =
  singleOrNull { it is I && predicate(it) }?.cast()

fun <T> Iterable<T>.singleOrNullOrThrow(): T? {
  when(this) {
    is List -> {
      return when(size) {
        0    -> null
        1    -> this[0]
        else -> throw IllegalArgumentException("List contains more than one matching element.")
      }
    }

    else    -> {
      val iterator = iterator()
      if(!iterator.hasNext()) return null

      val single = iterator.next()
      if(iterator.hasNext()) throw IllegalArgumentException("Collection contains more than one matching element.")

      return single
    }
  }
}

inline fun <T> Iterable<T>.singleOrNullOrThrow(predicate: (T) -> Boolean): T? {
  var single: T? = null
  var found = false
  for(element in this) {
    if(predicate(element)) {
      if(found) throw IllegalArgumentException("Collection contains more than one matching element.")
      single = element
      found = true
    }
  }
  if(!found) return null

  @Suppress("UNCHECKED_CAST")
  return single as T
}

fun <T : Any, R : Any> Iterable<T>.toListOf(type: KClass<R>, check: Boolean): List<R> = toList().asListOf(type, check)
inline fun <T : Any, reified R : Any> Iterable<T>.toListOf(check: Boolean): List<R> = toListOf(R::class, check)
