package jp.assasans.araumi.tx.server.network.config

import com.fasterxml.jackson.annotation.JsonProperty

data class InitConfiguration(
  val configVersion: String,
  val bundleDbVersion: String,
  val host: String,
  @get:JsonProperty("acceptorPort") val port: Int,
  val resourcesUrl: String,
  val configsUrl: String,
  val updateConfigUrl: String,
  val stateFileUrl: String
)
