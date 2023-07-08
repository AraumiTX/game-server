package jp.assasans.araumi.tx.server.ecs.events.entrance

import mu.KotlinLogging
import jp.assasans.araumi.tx.server.ecs.components.entrance.WebIdComponent
import jp.assasans.araumi.tx.server.ecs.entities.IEntity
import jp.assasans.araumi.tx.server.ecs.events.IServerEvent
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1478774431678)
data class ClientLaunchEvent(
  val webId: String
) : IServerEvent {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
    val logger = KotlinLogging.logger { }

    connection.clientSession.addComponent(WebIdComponent())

    logger.debug { "Executed launch event" }
  }
}
