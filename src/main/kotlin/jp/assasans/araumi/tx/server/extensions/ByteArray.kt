package jp.assasans.araumi.tx.server.extensions

import java.io.InputStream
import java.nio.ByteBuffer
import java.nio.file.Path
import java.security.MessageDigest
import java.util.zip.CRC32
import kotlin.io.path.inputStream
import kotlin.reflect.full.staticProperties
import kotlin.reflect.jvm.isAccessible
import sun.misc.Unsafe

@OptIn(ExperimentalUnsignedTypes::class)
fun ByteArray.toHexString(withSpaces: Boolean = false) = asUByteArray()
  .joinToString(if(withSpaces) " " else "") { byte ->
    byte.toString(16).padStart(2, '0')
  }

fun String.decodeHex(): ByteArray {
  check(length % 2 == 0) { "Must have an even length" }

  return chunked(2)
    .map { it.toInt(16).toByte() }
    .toByteArray()
}

@OptIn(ExperimentalUnsignedTypes::class)
fun ByteBuffer.toHexString(withSpaces: Boolean = false) = getFully().toHexString(withSpaces)

fun ByteBuffer.getNBytes(count: Int): ByteArray {
  val buffer = ByteArray(count)
  get(buffer)
  return buffer
}

fun ByteBuffer.getFully(): ByteArray = getNBytes(remaining())

inline fun <T> ByteBuffer.savePosition(block: ByteBuffer.() -> T): T {
  val position = position()
  try {
    return block(this)
  } finally {
    position(position)
  }
}

@Suppress("UnusedReceiverParameter")
fun Any?.unit() = Unit

inline fun <E> MutableList<E>.getOrPut(get: MutableList<E>.() -> E?, put: MutableList<E>.() -> E): E {
  get(this)?.let { return it }
  return put(this).also { add(it) }
}

class UnsafeUtils private constructor() {
  companion object {
    private var unsafe: Unsafe? = null

    fun get(): Unsafe {
      if(unsafe == null) {
        val property = Unsafe::class.staticProperties.single { it.name == "theUnsafe" }
        property.isAccessible = true

        unsafe = property.get() as Unsafe
      }

      return requireNotNull(unsafe)
    }
  }
}

inline fun <IK, IV, OK, OV> Map<IK, IV>.transform(block: (Map.Entry<IK, IV>) -> Pair<OK, OV>): Map<OK, OV> {
  val map = mutableMapOf<OK, OV>()
  forEach {
    val (key, value) = block(it)
    map[key] = value
  }

  return map
}

fun ByteArray.hash(algorithm: String): ByteArray {
  val digest = MessageDigest.getInstance(algorithm)
  digest.update(this)
  return digest.digest()
}

fun InputStream.hash(algorithm: String): ByteArray {
  return readAllBytes().hash(algorithm)
}

fun Path.hash(algorithm: String): ByteArray = inputStream().use { it.hash(algorithm) }

fun ByteArray.crc32(): Long {
  val crc = CRC32()
  crc.update(this)
  return crc.value
}

fun ByteArray.startsWith(sequence: ByteArray): Boolean {
  if(sequence.isEmpty()) return true
  if(isEmpty()) return false
  if(sequence.size > size) return false

  var index = 0
  while(index < sequence.size) {
    val value = this[index]

    if(value != sequence[index++]) return false
  }

  return true
}

fun ByteArray.indexOfSequence(sequence: ByteArray, startFrom: Int = 0): Int {
  if(startFrom < 0) throw IllegalArgumentException("startFrom must be >= 0")
  if(isEmpty()) return -1
  if(sequence.isEmpty()) return 0
  if(startFrom + sequence.size > size) return -1

  var index = startFrom
  var matchIndex = 0
  while(index < size) {
    val value = this[index++]

    if(matchIndex != 0 && value != sequence[matchIndex]) matchIndex = 0
    if(value == sequence[matchIndex]) matchIndex++

    if(matchIndex == sequence.size) return index - matchIndex
  }

  return -1
}
