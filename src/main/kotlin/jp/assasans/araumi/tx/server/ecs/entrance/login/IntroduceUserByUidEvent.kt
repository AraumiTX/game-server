package jp.assasans.araumi.tx.server.ecs.entrance.login

import kotlin.random.Random
import io.ktor.util.*
import mu.KotlinLogging
import jp.assasans.araumi.tx.server.ecs.IEntity
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import jp.assasans.araumi.tx.server.protocol.ProtocolId
import jp.assasans.araumi.tx.server.protocol.ProtocolName

@ProtocolId(1439375251389)
class IntroduceUserByUidEvent(
  captcha: String?,
  @ProtocolName("uid") val username: String
) : IntroduceUserEvent(captcha) {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
    val logger = KotlinLogging.logger { }
    val (clientSession) = entities

    logger.debug { "Login by username: $username" }
    clientSession.send(PersonalPasscodeEvent(Random.nextBytes(32).encodeBase64())) // Same as hash length (SHA-256)
  }
}
