package jp.assasans.araumi.tx.server.resources

import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.absolute
import kotlin.io.path.exists
import kotlin.io.path.pathString
import mu.KotlinLogging

class ResourceManager : IResourceManager {
  companion object {
    const val EnvName = "RUNTIME_RESOURCES"
  }

  private val logger = KotlinLogging.logger { }

  override lateinit var root: Path
    private set

  override fun init() {
    try {
      // Override with environment variable
      System.getenv(EnvName)?.takeIf(String::isNotEmpty)?.let {
        val directory = Paths.get(it)
        if(!directory.exists()) throw Exception("Cannot find runtime resources directory: ${directory.absolute().pathString}")

        root = directory
        return
      }

      var directory = Paths.get("data")
      if(!directory.exists()) directory = Paths.get("../data") // Gradle distribution / jar
      if(!directory.exists()) directory = Paths.get("src/main/resources/data") // Started from IntelliJ IDEA, default working directory
      if(!directory.exists()) directory = Paths.get("../src/main/resources/data") // Started from IntelliJ IDEA, 'out' working directory
      if(!directory.exists()) throw Exception("Cannot find runtime resources directory")

      root = directory
    } finally {
      logger.info { "Runtime resources root: ${this.root}" }
    }
  }

  override fun get(path: String): Path = root.resolve(path)
}
