package jp.assasans.araumi.tx.server.extensions

import io.ktor.utils.io.*

suspend fun ByteReadChannel.readNBytes(length: Int): ByteArray {
  val buffer = ByteArray(length)
  readFully(buffer)
  return buffer
}
