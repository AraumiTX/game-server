package jp.assasans.araumi.tx.server.protocol.command

import kotlin.reflect.KClass
import jp.assasans.araumi.tx.server.ecs.components.IComponent
import jp.assasans.araumi.tx.server.ecs.entities.IEntity
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import jp.assasans.araumi.tx.server.protocol.ProtocolPosition
import jp.assasans.araumi.tx.server.protocol.ProtocolVaried

class ComponentRemoveCommand(
  entity: IEntity,
  @ProtocolVaried
  @ProtocolPosition(1) val component: KClass<out IComponent>
) : EntityCommand(entity) {
  override suspend fun execute(connection: IPlayerConnection) {
    TODO("Not yet implemented")
  }
}
