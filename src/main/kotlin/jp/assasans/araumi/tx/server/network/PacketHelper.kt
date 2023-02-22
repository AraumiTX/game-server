package jp.assasans.araumi.tx.server.network

import kotlin.math.ceil
import io.ktor.utils.io.*
import jp.assasans.araumi.tx.server.extensions.readNBytes

object PacketHelper {
  suspend fun wrap(stream: ByteWriteChannel, buffer: ProtocolBuffer) {
    // Header
    stream.writeByte(UByte.MAX_VALUE.toInt())
    stream.writeByte(UByte.MIN_VALUE.toInt())

    // Sizes
    stream.writeInt(buffer.optionalMap.size)
    stream.writeInt(buffer.data.availableForRead)

    // Optional map
    stream.writeFully(buffer.optionalMap.map, 0, getSizeInBytes(buffer.optionalMap.size))

    // Data
    buffer.data.close()
    buffer.data.copyTo(stream)

    stream.close()
  }

  suspend fun unwrap(stream: ByteReadChannel, buffer: ProtocolBuffer): Boolean {
    // Header
    stream.readByte().toUByte().let { check(it == UByte.MAX_VALUE) { "Invalid header byte 1: $it" } }
    stream.readByte().toUByte().let { check(it == UByte.MIN_VALUE) { "Invalid header byte 2: $it" } }

    // Sizes
    val optionalMapBits = stream.readInt()
    val optionalMapBytes = getSizeInBytes(optionalMapBits)

    val dataSize = stream.readInt()

    // Optional map
    buffer.clear()
    buffer.optionalMap.fill(stream.readNBytes(optionalMapBytes), optionalMapBits)

    // Data
    stream.copyTo(buffer.data, dataSize.toLong())

    return true
  }

  private fun getSizeInBytes(size: Int): Int {
    return ceil(size.toDouble() / 8.0).toInt()
  }
}
