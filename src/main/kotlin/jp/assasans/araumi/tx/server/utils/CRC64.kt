package jp.assasans.araumi.tx.server.utils

import java.io.IOException
import java.io.InputStream
import java.util.zip.Checksum

// https://github.com/MrBuddyCasino/crc-64/blob/master/crc-64/src/main/java/net/boeckling/crc/CRC64.java
class CRC64 : Checksum {
  // Current CRC value
  private var value: Long

  constructor() {
    this.value = 0
  }

  /**
   * Initialize with a custom CRC value.
   *
   * @param value
   */
  constructor(value: Long) {
    this.value = value
  }

  /**
   * Initialize by calculating the CRC of the given byte blocks.
   *
   * @param b block of bytes
   * @param len number of bytes to process
   */
  constructor(b: ByteArray, len: Int) {
    value = 0
    update(b, len)
  }

  /**
   * Initialize by calculating the CRC of the given byte blocks.
   *
   * @param b block of bytes
   * @param off starting offset of the byte block
   * @param len number of bytes to process
   */
  constructor(b: ByteArray, off: Int, len: Int) {
    value = 0
    update(b, off, len)
  }

  /**
   * Get 8 byte representation of current CRC64 value.
   */
  val bytes: ByteArray
    get() {
      val b = ByteArray(8)
      for(i in 0..7) {
        b[7 - i] = (value ushr i * 8).toByte()
      }
      return b
    }

  /**
   * Get long representation of current CRC64 value.
   */
  override fun getValue(): Long {
    return value
  }

  /**
   * Update CRC64 with new byte block.
   */
  fun update(b: ByteArray, len: Int) {
    this.update(b, 0, len)
  }

  /**
   * Update CRC64 with new byte block.
   */
  override fun update(b: ByteArray, off: Int, len: Int) {
    var len = len
    value = value.inv()

    // Fast middle processing, 8 bytes (aligned!) per loop
    var idx = off
    while(len >= 8) {
      value = table[7][(value and 0xffL xor (b[idx].toInt() and 0xff).toLong()).toInt()] xor
        table[6][(value ushr 8 and 0xffL xor (b[idx + 1].toInt() and 0xff).toLong()).toInt()] xor
        table[5][(value ushr 16 and 0xffL xor (b[idx + 2].toInt() and 0xff).toLong()).toInt()] xor
        table[4][(value ushr 24 and 0xffL xor (b[idx + 3].toInt() and 0xff).toLong()).toInt()] xor
        table[3][(value ushr 32 and 0xffL xor (b[idx + 4].toInt() and 0xff).toLong()).toInt()] xor
        table[2][(value ushr 40 and 0xffL xor (b[idx + 5].toInt() and 0xff).toLong()).toInt()] xor
        table[1][(value ushr 48 and 0xffL xor (b[idx + 6].toInt() and 0xff).toLong()).toInt()] xor
        table[0][(value ushr 56 xor (b[idx + 7].toInt() and 0xff).toLong()).toInt()]

      idx += 8
      len -= 8
    }

    // Process remaining bytes (can't be larger than 8)
    while(len > 0) {
      value = table[0][(value xor b[idx].toLong() and 0xffL).toInt()] xor (value ushr 8)
      idx++
      len--
    }
    value = value.inv()
  }

  override fun update(b: Int) {
    this.update(byteArrayOf(b.toByte()), 0, 1)
  }

  override fun reset() {
    value = 0
  }

  companion object {
    private const val POLY = -0x3693a86a2878f0be // ECMA-182, 0xc96c5795d7870f42

    // CRC64 calculation table
    private val table: Array<LongArray> = Array(8) { LongArray(256) }

    init {
      for(n in 0..255) {
        var crc = n.toLong()
        for(k in 0..7) {
          crc = if(crc and 1L == 1L) {
            crc ushr 1 xor POLY
          } else {
            crc ushr 1
          }
        }
        table[0][n] = crc
      }

      // Generate nested CRC table for future slice-by-8 lookup
      for(n in 0..255) {
        var crc = table[0][n]
        for(k in 1..7) {
          crc = table[0][(crc and 0xffL).toInt()] xor (crc ushr 8)
          table[k][n] = crc
        }
      }
    }

    /**
     * Construct new CRC64 instance from byte array.
     */
    fun fromBytes(b: ByteArray): CRC64 {
      var l: Long = 0
      for(i in 0..3) {
        l = l shl 8
        l = l xor (b[i].toLong() and 0xFFL)
      }
      return CRC64(l)
    }

    /**
     * Calculate the CRC64 of the given [InputStream] until the end of the
     * stream has been reached.
     *
     * @param stream
     * the stream will be closed automatically
     * @return new [CRC64] instance initialized to the [InputStream]'s CRC value
     * @throws IOException
     * in case the [InputStream.read] method fails
     */
    @Throws(IOException::class) fun fromInputStream(stream: InputStream): CRC64 {
      val crc = CRC64()
      val b = ByteArray(65536)
      var l: Int
      while(stream.read(b).also { l = it } != -1) {
        crc.update(b, l)
      }
      return crc
    }

    // Dimension of GF(2) vectors (length of CRC)
    private const val GF2_DIM = 64
    private fun gf2MatrixTimes(mat: LongArray, vec: Long): Long {
      var vec = vec
      var sum: Long = 0
      var idx = 0
      while(vec != 0L) {
        if(vec and 1L == 1L) sum = sum xor mat[idx]
        vec = vec ushr 1
        idx++
      }
      return sum
    }

    private fun gf2MatrixSquare(square: LongArray, mat: LongArray) {
      for(n in 0 until GF2_DIM) square[n] = gf2MatrixTimes(mat, mat[n])
    }

    /*
     * Return the CRC64 of two sequential blocks, where summ1 is the CRC64 of
     * the first block, summ2 is the CRC64 of the second block, and len2 is the
     * length of the second block.
     */
    fun combine(summ1: CRC64, summ2: CRC64, len2: Long): CRC64 {
      // Degenerate case
      var len2 = len2
      if(len2 == 0L) return CRC64(summ1.getValue())
      var n: Int
      var row: Long
      val even = LongArray(GF2_DIM) // Even-power-of-two zeros operator
      val odd = LongArray(GF2_DIM) // Odd-power-of-two zeros operator

      // Put operator for one zero bit in odd
      odd[0] = POLY // CRC64 polynomial
      row = 1
      n = 1
      while(n < GF2_DIM) {
        odd[n] = row
        row = row shl 1
        n++
      }

      // Put operator for two zero bits in even
      gf2MatrixSquare(even, odd)

      // Put operator for four zero bits in odd
      gf2MatrixSquare(odd, even)

      // Apply len2 zeros to crc1 (first square will put the operator for one
      // zero byte, eight zero bits, in even)
      var crc1 = summ1.getValue()
      val crc2 = summ2.getValue()
      do {
        // Apply zeros operator for this bit of len2
        gf2MatrixSquare(even, odd)
        if(len2 and 1L == 1L) crc1 = gf2MatrixTimes(even, crc1)
        len2 = len2 ushr 1

        // If no more bits set, then done
        if(len2 == 0L) break

        // Another iteration of the loop with odd and even swapped
        gf2MatrixSquare(odd, even)
        if(len2 and 1L == 1L) crc1 = gf2MatrixTimes(odd, crc1)
        len2 = len2 ushr 1

        // If no more bits set, then done
      } while(len2 != 0L)

      // Return combined CRC
      crc1 = crc1 xor crc2
      return CRC64(crc1)
    }
  }
}

fun crc64(value: ByteArray): Long {
  val crc = CRC64()
  crc.update(value)
  return crc.value
}

fun crc64(value: String): Long = crc64(value.toByteArray())
