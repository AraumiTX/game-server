package jp.assasans.araumi.tx.server

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import com.github.ajalt.clikt.core.CliktCommand
import mu.KotlinLogging
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module
import org.koin.logger.SLF4JLogger
import jp.assasans.araumi.tx.server.config.ClientConfigGenerator
import jp.assasans.araumi.tx.server.config.IClientConfigGenerator
import jp.assasans.araumi.tx.server.ecs.entities.EntityRegistry
import jp.assasans.araumi.tx.server.ecs.entities.IEntityRegistry
import jp.assasans.araumi.tx.server.extensions.get
import jp.assasans.araumi.tx.server.extensions.inject
import jp.assasans.araumi.tx.server.network.GameServer
import jp.assasans.araumi.tx.server.network.IGameServer
import jp.assasans.araumi.tx.server.network.config.ConfigServer
import jp.assasans.araumi.tx.server.network.config.IConfigServer
import jp.assasans.araumi.tx.server.protocol.IProtocol
import jp.assasans.araumi.tx.server.protocol.Protocol
import jp.assasans.araumi.tx.server.resources.IResourceManager
import jp.assasans.araumi.tx.server.resources.ResourceManager
import jp.assasans.araumi.tx.server.utils.IClassScanner
import jp.assasans.araumi.tx.server.utils.IStartupTimer
import jp.assasans.araumi.tx.server.utils.ReflectionsClassScanner
import jp.assasans.araumi.tx.server.utils.StartupTimer

fun main(args: Array<String>) = object : CliktCommand() {
  private val logger = KotlinLogging.logger("jp.assasans.araumi.tx.server.MainKt")

  private fun startKoin(startupTimer: IStartupTimer) {
    val module = module {
      /* Core */
      single<IStartupTimer> { startupTimer }
      single<IClassScanner> { ReflectionsClassScanner() }
      single<IResourceManager> { ResourceManager() }

      /* Network */
      single<IProtocol> { Protocol() }
      single<IGameServer> { GameServer() }
      single<IConfigServer> { ConfigServer() }
      single<IClientConfigGenerator> { ClientConfigGenerator() }

      /* ECS */
      single<IEntityRegistry> { EntityRegistry() }
    }

    startKoin {
      logger(SLF4JLogger(Level.ERROR))
      modules(module)
    }
  }

  override fun run(): Unit = runBlocking {
    logger.info { "Hello, 世界!" }

    val startupTimer = StartupTimer()
    startupTimer.start()

    startKoin(startupTimer)

    get<IResourceManager>().init()

    val configServer by inject<IConfigServer>()
    configServer.start()

    val gameServer by inject<IGameServer>()
    gameServer.bind()
    launch { gameServer.accept() }
  }
}.main(args)
