package jp.assasans.araumi.tx.server.protocol.buffer

import java.util.*
import kotlin.experimental.xor

class OptionalMap {
  companion object {
    private const val DefaultSize = 5000
  }

  var size: Int = 0
    private set
  var readPosition: Int = 0
    private set
  lateinit var map: ByteArray
    private set

  val has: Boolean
    get() = readPosition < size

  init {
    fill(ByteArray(DefaultSize), 0)
  }

  fun fill(map: ByteArray, size: Int) {
    this.map = map
    this.size = size
    this.readPosition = 0
  }

  fun clear() {
    Arrays.fill(map, 0)
    size = map.size
    readPosition = 0
  }

  fun reset() {
    readPosition = 0
  }

  fun add(isNull: Boolean) = setBit(size++, isNull)

  fun getLast(): Boolean = getBit(--size)

  fun concat(another: OptionalMap) {
    for(index in 0 until another.size) {
      add(another.getBit(index))
    }
  }

  fun get(): Boolean {
    if(readPosition >= size) throw IndexOutOfBoundsException()
    return getBit(readPosition++)
  }

  private fun getBit(position: Int): Boolean {
    val num = position shr 3
    val num2 = 7 xor (position and 7)
    return (map[num].toInt() and (1 shl num2)) != 0
  }

  private fun setBit(position: Int, value: Boolean) {
    val num = position shr 3
    val num2 = 7 xor (position and 7)
    if(value) {
      map[num] = (map[num].toInt() or (1 shl num2)).toByte()
      return
    }
    val b = (0xFF.toByte() xor (1 shl num2).toByte())
    map[num] = (map[num].toInt() and b.toInt()).toByte()
  }

  override fun toString(): String {
    return buildString {
      append("OptionalMap(size=$size, data=")
      for(index in 0 until size) {
        append(if(getBit(index)) "1" else "0")
        if(index == readPosition) append("<->")
      }
      append(")")
    }
  }

  fun duplicate(): OptionalMap {
    val optionalMap = OptionalMap()
    optionalMap.size = size
    optionalMap.readPosition = readPosition
    System.arraycopy(map, 0, optionalMap.map, 0, map.size)

    return optionalMap
  }
}
