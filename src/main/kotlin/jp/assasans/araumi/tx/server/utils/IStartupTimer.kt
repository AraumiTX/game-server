package jp.assasans.araumi.tx.server.utils

import kotlin.time.Duration
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import mu.KotlinLogging

interface IStartupTimer {
  val start: Instant?
  val finish: Instant?

  fun start()
  fun finish()
}

val IStartupTimer.completed: Boolean
  get() = start != null && finish != null

val IStartupTimer.elapsed: Duration
  get() = (finish ?: Clock.System.now()) - requireNotNull(start)

// Note: Koin is not started at the moment of this class being used
class StartupTimer : IStartupTimer {
  private val logger = KotlinLogging.logger { }

  override var start: Instant? = null
  override var finish: Instant? = null

  override fun start() {
    require(finish == null) { "Timer has been already finished" }
    start = Clock.System.now()
  }

  override fun finish() {
    require(start != null) { "Timer has not been started" }
    finish = Clock.System.now()

    logger.info { "Server has been started in $elapsed" }
  }
}
