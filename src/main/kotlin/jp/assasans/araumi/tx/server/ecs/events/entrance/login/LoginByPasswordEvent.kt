package jp.assasans.araumi.tx.server.ecs.events.entrance.login

import jp.assasans.araumi.tx.server.ecs.entities.IEntity
import jp.assasans.araumi.tx.server.ecs.events.IServerEvent
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1437480091995)
data class LoginByPasswordEvent(
  val passwordEncipher: String,
  val rememberMe: Boolean,
  val hardwareFingerprint: String
) : IServerEvent {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) =
    connection.login(rememberMe, passwordEncipher, hardwareFingerprint)
}
