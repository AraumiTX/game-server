package jp.assasans.araumi.tx.server.extensions

inline fun <K, V : Any, reified I : V> Map<K, V>.singleOf(): I = values.singleOf()
inline fun <K, V : Any, reified I : V> Map<K, V>.singleOf(predicate: (I) -> Boolean): I = values.singleOf(predicate)

inline fun <K, V> MutableMap<K, V>.putOr(key: K, value: V, present: (Pair<K, V>) -> Unit) {
  this[key]?.let { return present(Pair(key, it)) }
  this[key] = value
}

inline fun <K, V> MutableMap<K, V>.removeOr(key: K, absent: (K) -> Unit) {
  remove(key) ?: return absent(key)
}

inline fun <K, V, T> Map<K, V>.groupBy(keySelector: (Pair<K, V>) -> T): Map<T, Map<K, V>> {
  // TODO: Optimize
  return toList()
    .groupBy(keySelector)
    .mapValues { (_, it) -> it.toMap() }
}

fun <K, V> Map<out K?, V>.filterKeysNotNull(): Map<K, V> {
  @Suppress("UNCHECKED_CAST")
  return filter { it.key != null } as Map<K, V>
}

fun <K, V> Map<out K, V?>.filterValuesNotNull(): Map<K, V> {
  @Suppress("UNCHECKED_CAST")
  return filter { it.value != null } as Map<K, V>
}
