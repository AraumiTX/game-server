package jp.assasans.araumi.tx.server.extensions

import kotlin.reflect.KClass
import kotlin.reflect.KType

val KType.kotlinClass: KClass<*>
  get() = classifier as KClass<*>
