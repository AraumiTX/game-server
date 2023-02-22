package jp.assasans.araumi.tx.server.ecs.entrance.login

import mu.KotlinLogging
import jp.assasans.araumi.tx.server.ecs.IEntity
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1458846544326)
class IntroduceUserByEmailEvent(
  captcha: String?,
  val email: String
) : IntroduceUserEvent(captcha) {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
    val logger = KotlinLogging.logger { }
    val (clientSession) = entities

    logger.debug { "Login by email: $email" }
  }
}
