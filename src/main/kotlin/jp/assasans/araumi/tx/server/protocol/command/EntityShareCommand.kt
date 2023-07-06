package jp.assasans.araumi.tx.server.protocol.command

import jp.assasans.araumi.tx.server.ecs.components.IComponent
import jp.assasans.araumi.tx.server.ecs.entities.templates.TemplateAccessor
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import jp.assasans.araumi.tx.server.protocol.ProtocolCollection
import jp.assasans.araumi.tx.server.protocol.ProtocolPosition

class EntityShareCommand(
  @ProtocolPosition(0) val entityId: Long,
  @ProtocolPosition(1) val templateAccessor: TemplateAccessor?,
  @ProtocolCollection(varied = true)
  @ProtocolPosition(2) val components: Array<IComponent>
) : ICommand {
  override suspend fun execute(connection: IPlayerConnection) {
    TODO("Not yet implemented")
  }
}
