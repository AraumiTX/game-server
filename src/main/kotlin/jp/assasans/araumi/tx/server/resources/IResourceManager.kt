package jp.assasans.araumi.tx.server.resources

import java.nio.file.Path

interface IResourceManager {
  val root: Path

  fun init()
  fun get(path: String): Path
}
