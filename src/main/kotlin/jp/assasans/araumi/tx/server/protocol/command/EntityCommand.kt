package jp.assasans.araumi.tx.server.protocol.command

import jp.assasans.araumi.tx.server.ecs.entities.IEntity
import jp.assasans.araumi.tx.server.protocol.ProtocolPosition

abstract class EntityCommand(
  @ProtocolPosition(0) val entity: IEntity
) : ICommand
