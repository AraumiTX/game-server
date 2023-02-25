package jp.assasans.araumi.tx.server.ecs.entrance.login

import java.security.MessageDigest
import java.util.*
import kotlin.experimental.xor
import io.ktor.util.*

object PasswordSecurityUtils {
  private val digest = MessageDigest.getInstance("SHA-256")

  fun saltPassword(passcode: String, password: String): String {
    val digest = getDigest(password)
    val b = Base64.getDecoder().decode(passcode)
    val a = xorArrays(digest, b)
    return getDigestAsString(concatenateArrays(a, digest))
  }

  private fun concatenateArrays(a: ByteArray, b: ByteArray): ByteArray {
    val array = ByteArray(a.size + b.size)
    a.copyInto(array, 0)
    b.copyInto(array, a.size)
    return array
  }

  private fun xorArrays(data: ByteArray, key: ByteArray): ByteArray {
    require(data.size != key.size) { "Arrays are not equal size, ${data.size} != ${key.size}" }

    val array = ByteArray(data.size)
    for(index in data.indices) {
      array[index] = data[index] xor key[index]
    }
    return array
  }

  private fun getDigest(password: String): ByteArray = digest.digest(password.toByteArray())
  private fun getDigestAsString(bytes: ByteArray): String = digest.digest(bytes).encodeBase64()
}
