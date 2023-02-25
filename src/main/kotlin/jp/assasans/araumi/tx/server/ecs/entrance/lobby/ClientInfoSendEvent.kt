package jp.assasans.araumi.tx.server.ecs.entrance.lobby

import mu.KotlinLogging
import jp.assasans.araumi.tx.server.ecs.IEntity
import jp.assasans.araumi.tx.server.ecs.IServerEvent
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1464349204724)
data class ClientInfoSendEvent(
  val settings: String
) : IServerEvent {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
    val logger = KotlinLogging.logger { }
    val (clientSession) = entities

    logger.debug { "Client settings: $this" }
  }
}
