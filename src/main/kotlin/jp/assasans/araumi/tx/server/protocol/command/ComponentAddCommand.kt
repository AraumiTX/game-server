package jp.assasans.araumi.tx.server.protocol.command

import mu.KotlinLogging
import jp.assasans.araumi.tx.server.ecs.components.IComponent
import jp.assasans.araumi.tx.server.ecs.entities.IEntity
import jp.assasans.araumi.tx.server.ecs.entities.IEntityInternal
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import jp.assasans.araumi.tx.server.protocol.ProtocolPosition
import jp.assasans.araumi.tx.server.protocol.ProtocolVaried

class ComponentAddCommand(
  entity: IEntity,
  @ProtocolVaried
  @ProtocolPosition(1) val component: IComponent
) : EntityCommand(entity) {
  override suspend fun execute(connection: IPlayerConnection) {
    val logger = KotlinLogging.logger { }

    (entity as IEntityInternal).addComponent(component, excluded = connection)
    logger.debug { "$connection added $component to $entity" }
  }
}
