package jp.assasans.araumi.tx.server.protocol

@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
annotation class ProtocolCollection(val nullable: Boolean = false, val varied: Boolean = false) {
  companion object {
    val Default = ProtocolCollection()
  }
}
