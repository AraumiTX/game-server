package jp.assasans.araumi.tx.server.protocol.codec.primitive

import kotlinx.datetime.Instant
import jp.assasans.araumi.tx.server.network.ProtocolBuffer
import jp.assasans.araumi.tx.server.protocol.codec.Codec

class InstantCodec : Codec<Instant>() {
  override suspend fun encode(buffer: ProtocolBuffer, value: Instant) {
    buffer.writer.writeLong(value.toEpochMilliseconds())
  }

  override suspend fun decode(buffer: ProtocolBuffer): Instant {
    return Instant.fromEpochMilliseconds(buffer.reader.readLong())
  }
}
