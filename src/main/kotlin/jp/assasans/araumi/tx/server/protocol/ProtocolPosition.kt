package jp.assasans.araumi.tx.server.protocol

@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
annotation class ProtocolPosition(val position: Int)
