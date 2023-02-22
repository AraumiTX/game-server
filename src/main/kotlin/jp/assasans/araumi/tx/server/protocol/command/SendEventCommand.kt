package jp.assasans.araumi.tx.server.protocol.command

import mu.KotlinLogging
import jp.assasans.araumi.tx.server.ecs.IEntity
import jp.assasans.araumi.tx.server.ecs.IEvent
import jp.assasans.araumi.tx.server.ecs.IServerEvent
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import jp.assasans.araumi.tx.server.protocol.ProtocolPosition
import jp.assasans.araumi.tx.server.protocol.ProtocolVaried

class SendEventCommand(
  @ProtocolVaried
  @ProtocolPosition(0) val event: IEvent,
  @ProtocolPosition(1) val entities: Array<IEntity>
) : ICommand {
  override suspend fun execute(connection: IPlayerConnection) {
    val logger = KotlinLogging.logger { }

    if(event !is IServerEvent) {
      logger.warn { "Event ${event::class} is not a IServerEvent" }
      return
    }

    event.execute(connection, entities)
    logger.info { "Received event $event for ${entities.size} entities" }
  }
}
