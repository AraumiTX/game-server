package jp.assasans.araumi.tx.server.network

import io.ktor.utils.io.*
import jp.assasans.araumi.tx.server.protocol.buffer.OptionalMap

class ProtocolBuffer(
  val optionalMap: OptionalMap
) {
  var data: ByteChannel = ByteChannel(true)
    private set

  val reader: ByteReadChannel get() = data
  val writer: ByteWriteChannel get() = data

  fun clear() {
    optionalMap.clear()

    data.close()
    data = ByteChannel(true)
  }
}

suspend fun ProtocolBuffer.wrap(writer: ByteWriteChannel) = PacketHelper.wrap(writer, this)
suspend fun ProtocolBuffer.unwrap(reader: ByteReadChannel) = PacketHelper.unwrap(reader, this)
