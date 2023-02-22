package jp.assasans.araumi.tx.server.protocol.command

import jp.assasans.araumi.tx.server.ecs.IComponent
import jp.assasans.araumi.tx.server.ecs.IEntity
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import jp.assasans.araumi.tx.server.protocol.ProtocolPosition
import jp.assasans.araumi.tx.server.protocol.ProtocolVaried

class ComponentChangeCommand(
  entity: IEntity,
  @ProtocolVaried
  @ProtocolPosition(1) val component: IComponent
) : EntityCommand(entity) {
  override suspend fun execute(connection: IPlayerConnection) {
    TODO("Not yet implemented")
  }
}
