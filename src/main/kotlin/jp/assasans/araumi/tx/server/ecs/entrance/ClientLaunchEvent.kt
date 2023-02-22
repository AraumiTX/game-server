package jp.assasans.araumi.tx.server.ecs.entrance

import mu.KotlinLogging
import jp.assasans.araumi.tx.server.ecs.IEntity
import jp.assasans.araumi.tx.server.ecs.IServerEvent
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1478774431678)
data class ClientLaunchEvent(
  val webId: String
) : IServerEvent {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
    val logger = KotlinLogging.logger { }

    val (clientSession) = entities
    clientSession.addComponent(WebIdComponent())

    logger.debug { "Executed launch event" }
  }
}
