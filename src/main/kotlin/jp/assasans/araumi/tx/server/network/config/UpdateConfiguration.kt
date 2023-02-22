package jp.assasans.araumi.tx.server.network.config

data class UpdateConfiguration(
  val lastClientVersion: String,
  val distributionUrl: String,
  val executable: String
)
