package jp.assasans.araumi.tx.server.ecs.entrance.login

import mu.KotlinLogging
import jp.assasans.araumi.tx.server.ecs.IEntity
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1439375251389)
class IntroduceUserByUidEvent(
  captcha: String?,
  val username: String // Original name: Uid
) : IntroduceUserEvent(captcha) {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
    val logger = KotlinLogging.logger { }
    val (clientSession) = entities

    logger.debug { "Login by username: $username" }
  }
}
