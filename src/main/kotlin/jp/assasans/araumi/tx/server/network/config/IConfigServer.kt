package jp.assasans.araumi.tx.server.network.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import mu.KotlinLogging
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import jp.assasans.araumi.tx.server.config.IClientConfigGenerator
import jp.assasans.araumi.tx.server.resources.IResourceManager

interface IConfigServer {
  suspend fun start()
  suspend fun stop()
}

class ConfigServer : IConfigServer, KoinComponent {
  private val logger = KotlinLogging.logger { }

  private val resourceManager: IResourceManager by inject()
  private val clientConfigGenerator: IClientConfigGenerator by inject()

  private lateinit var engine: ApplicationEngine

  override suspend fun start() {
    val mapper = ObjectMapper(YAMLFactory().enable(YAMLGenerator.Feature.MINIMIZE_QUOTES))

    engine = embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
      install(CallLogging)

      routing {
        get("state/tankixprod_state.yml") {
          call.respondBytes {
            mapper.writeValueAsBytes(StateConfiguration(
              state = 0
            ))
          }
        }

        get("config/init.yml") {
          call.respondBytes {
            mapper.writeValueAsBytes(InitConfiguration(
              configVersion = "",
              bundleDbVersion = "master-48606",
              host = "127.0.0.1",
              port = 5050,
              resourcesUrl = "http://127.0.0.1:8080/resources",
              configsUrl = "http://127.0.0.1:8080/config",
              updateConfigUrl = "http://127.0.0.1:8080/update/{BuildTarget}.yml",
              stateFileUrl = ""
            ))
          }
        }

        get("update/{buildTarget}") {
          val buildTarget = requireNotNull(call.parameters["buildTarget"])

          call.respondBytes {
            mapper.writeValueAsBytes(UpdateConfiguration(
              lastClientVersion = "master-48606",
              distributionUrl = "http://127.0.0.1:8080/update/$buildTarget.tgz",
              executable = "tankix.exe"
            ))
          }
        }

        get("resources/{buildTarget}/{file}") {
          val buildTarget = requireNotNull(call.parameters["buildTarget"])
          val file = requireNotNull(call.parameters["file"])

          call.respondFile(resourceManager.get("game-resources/asset-bundles/$buildTarget/$file").toFile())
        }

        get("config/{version}/{locale}/config.tar.gz") {
          call.respondBytes { clientConfigGenerator.create() }
        }
      }
    }.start()

    logger.info { "Started config server" }
  }

  override suspend fun stop() {
    engine.stop()
  }
}
