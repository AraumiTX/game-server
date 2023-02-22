package jp.assasans.araumi.tx.server.protocol

@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
annotation class ProtocolMap(
  val key: ProtocolCollection = ProtocolCollection(),
  val value: ProtocolCollection = ProtocolCollection()
) {
  companion object {
    val Default = ProtocolMap()
  }
}
