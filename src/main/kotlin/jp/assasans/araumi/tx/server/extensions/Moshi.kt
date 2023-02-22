package jp.assasans.araumi.tx.server.extensions

import com.squareup.moshi.JsonWriter

inline fun JsonWriter.jsonObject(block: () -> Unit) {
  beginObject()
  try {
    block()
  } finally {
    endObject()
  }
}

inline fun JsonWriter.array(block: () -> Unit) {
  beginArray()
  try {
    block()
  } finally {
    endArray()
  }
}

inline fun JsonWriter.flatten(block: () -> Unit) {
  val token = beginFlatten()
  try {
    block()
  } finally {
    endFlatten(token)
  }
}
