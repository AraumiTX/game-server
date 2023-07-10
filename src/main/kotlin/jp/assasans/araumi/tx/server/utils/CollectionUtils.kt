package jp.assasans.araumi.tx.server.utils

class CollectionUtils {
  inline fun <IK, IV, OK, OV> Map<IK, IV>.transform(block: (Map.Entry<IK, IV>) -> Pair<OK, OV>): Map<OK, OV> {
    val map = mutableMapOf<OK, OV>()
    forEach {
      val (key, value) = block(it)
      map[key] = value
    }

    return map
  }
}
