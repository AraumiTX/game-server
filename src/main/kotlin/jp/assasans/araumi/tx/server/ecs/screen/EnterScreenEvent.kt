package jp.assasans.araumi.tx.server.ecs.screen

import mu.KotlinLogging
import jp.assasans.araumi.tx.server.ecs.IEntity
import jp.assasans.araumi.tx.server.ecs.IServerEvent
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1453867134827)
data class EnterScreenEvent(
  val screen: String
) : IServerEvent {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
    val logger = KotlinLogging.logger { }

    val (clientSession) = entities
    logger.debug { "$clientSession entered screen $screen" }
  }
}
