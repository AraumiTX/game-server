package jp.assasans.araumi.tx.server.extensions

inline val Short.highByte: Byte get() = (toInt() ushr 8).toByte()
inline val Short.lowByte: Byte get() = (toInt() and 0xff).toByte()

inline val Int.highShort: Short get() = (this ushr 16).toShort()
inline val Int.lowShort: Short get() = (this and 0xffff).toShort()

inline val Long.highInt: Int get() = (this ushr 32).toInt()
inline val Long.lowInt: Int get() = (this and 0xffffffffL).toInt()
