package jp.assasans.araumi.tx.server.utils

import kotlin.time.Duration
import kotlin.time.Duration.Companion.nanoseconds

class Stopwatch {
  companion object {
    fun startNew() = Stopwatch().also { it.start() }
  }

  private var start: Long? = null
  private var end: Long? = null

  val elapsed: Duration
    get() {
      val start = requireNotNull(start) { "Timer is not started" }
      val end = end ?: System.nanoTime()

      return (end - start).nanoseconds
    }

  fun start() {
    start = System.nanoTime()
    end = null
  }

  fun stop() {
    require(start != null) { "Timer is not started" }
    require(end == null) { "Timer is stopped" }

    end = System.nanoTime()
  }
}
