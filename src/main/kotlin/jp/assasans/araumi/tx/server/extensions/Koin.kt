package jp.assasans.araumi.tx.server.extensions

import org.koin.java.KoinJavaComponent

inline fun <reified T> get(): T = KoinJavaComponent.get(T::class.java)
inline fun <reified T> inject(): Lazy<T> = KoinJavaComponent.inject(T::class.java)
