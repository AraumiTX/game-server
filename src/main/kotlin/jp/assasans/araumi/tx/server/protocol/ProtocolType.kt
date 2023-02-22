package jp.assasans.araumi.tx.server.protocol

import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class ProtocolType(val type: KClass<*>)
