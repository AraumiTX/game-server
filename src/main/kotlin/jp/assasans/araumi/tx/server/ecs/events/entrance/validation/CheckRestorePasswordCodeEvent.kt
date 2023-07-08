package jp.assasans.araumi.tx.server.ecs.events.entrance.validation

import jp.assasans.araumi.tx.server.ecs.entities.IEntity
import jp.assasans.araumi.tx.server.ecs.events.IServerEvent
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import jp.assasans.araumi.tx.server.network.send
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1460402752765)
data class CheckRestorePasswordCodeEvent(
  val code: String
) : IServerEvent {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
    if(code == "valid") connection.send(RestorePasswordCodeValidEvent(code))
    else connection.send(RestorePasswordCodeInvalidEvent(code))
  }
}
