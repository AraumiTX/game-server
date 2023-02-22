package jp.assasans.araumi.tx.server.protocol.codec

import io.ktor.utils.io.*

object VarIntCodecHelper {
  suspend fun encode(writer: ByteWriteChannel, value: Int) {
    require(value in 0 until 0x400000) { "Cannot encode value: $value" }

    when {
      value < 0x80     -> {
        writer.writeByte(value and 0x7F)
      }

      value < 0x4000   -> {
        val temp = (value and 0x3FFF) + 0x8000
        writer.writeByte(temp and 0xFF00 shr 8)
        writer.writeByte(temp and 0xFF)
      }

      value < 0x400000 -> {
        val temp = (value and 0x3FFFFF) + 0xC00000
        writer.writeByte(temp and 0xFF0000 shr 16)
        writer.writeByte(temp and 0xFF00 shr 8)
        writer.writeByte(temp and 0xFF)
      }
    }
  }

  suspend fun decode(reader: ByteReadChannel): Int {
    val byte1 = reader.readByte()
    if(byte1.toInt() and 0x80 == 0) return byte1.toInt()

    val byte2 = reader.readByte()
    if(byte1.toInt() and 0x40 == 0) return (byte1.toInt() and 0x3F shl 8) +
                                           (byte2.toInt() and 0xFF)

    val byte3 = reader.readByte()
    return (byte1.toInt() and 0x3F shl 16) +
           (byte2.toInt() and 0xFF shl 8) +
           (byte3.toInt() and 0xFF)
  }
}
