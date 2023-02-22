package jp.assasans.araumi.tx.server.config

import java.io.ByteArrayOutputStream
import java.util.zip.GZIPOutputStream
import mu.KotlinLogging
import org.apache.commons.compress.archivers.tar.TarArchiveEntry
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import jp.assasans.araumi.tx.server.resources.IResourceManager

interface IClientConfigGenerator {
  suspend fun create(): ByteArray
}

// TODO: Split by locales
class ClientConfigGenerator : IClientConfigGenerator, KoinComponent {
  private val logger = KotlinLogging.logger { }

  private val resourceManager: IResourceManager by inject()

  private var cached: ByteArray? = null

  override suspend fun create(): ByteArray {
    if(cached == null) {
      val root = resourceManager.get("game-resources/client-config/master-48606")
      val entries = root.toFile().walk()
        .filter { it.isFile }
        .map { file ->
          // logger.debug { "File: ${file.relativeTo(root.toFile()).normalize().path}" }
          TarArchiveEntry(file)
        }

      val byteStream = ByteArrayOutputStream()
      val gzipStream = GZIPOutputStream(byteStream)
      val tarStream = TarArchiveOutputStream(gzipStream)

      entries.forEach { entry ->
        entry.name = entry.file.relativeTo(root.toFile()).normalize().path

        tarStream.putArchiveEntry(entry)
        tarStream.write(entry.file.readBytes())
        tarStream.closeArchiveEntry()
      }

      tarStream.finish()
      tarStream.close()

      cached = byteStream.toByteArray()
    }

    return cached!!
  }
}
