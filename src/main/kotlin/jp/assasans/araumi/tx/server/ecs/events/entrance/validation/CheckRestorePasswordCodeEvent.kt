package jp.assasans.araumi.tx.server.ecs.events.entrance.validation

import jp.assasans.araumi.tx.server.ecs.entities.IEntity
import jp.assasans.araumi.tx.server.ecs.events.IServerEvent
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1460402752765)
data class CheckRestorePasswordCodeEvent(
  val code: String
) : IServerEvent {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
    val (clientSession) = entities

    if(code == "valid") clientSession.send(RestorePasswordCodeValidEvent(code))
    else clientSession.send(RestorePasswordCodeInvalidEvent(code))
  }
}
