package jp.assasans.araumi.tx.server.utils

import kotlin.reflect.KClass
import org.reflections.Reflections

interface IClassScanner {
  fun <T : Any> getSubtypesOf(type: KClass<T>): Set<KClass<out T>>
  fun <T : Annotation> getAnnotatedWith(type: KClass<T>): Set<KClass<out Any>>
}

inline fun <reified T : Any> IClassScanner.getSubtypesOf() = getSubtypesOf(T::class)
inline fun <reified T : Annotation> IClassScanner.getAnnotatedWith() = getAnnotatedWith(T::class)

class ReflectionsClassScanner : IClassScanner {
  val reflections = Reflections("jp.assasans.araumi.tx.server")

  override fun <T : Any> getSubtypesOf(type: KClass<T>): Set<KClass<out T>> {
    return reflections.getSubTypesOf(type.java).map { it.kotlin }.toSet()
  }

  override fun <T : Annotation> getAnnotatedWith(type: KClass<T>): Set<KClass<out Any>> {
    return reflections.getTypesAnnotatedWith(type.java).map { it.kotlin }.toSet()
  }
}
