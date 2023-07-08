package jp.assasans.araumi.tx.server.ecs.events.entrance.restorePassword

import jp.assasans.araumi.tx.server.ecs.Player
import jp.assasans.araumi.tx.server.ecs.components.entrance.restorePassword.RestorePasswordCodeSentComponent
import jp.assasans.araumi.tx.server.ecs.entities.IEntity
import jp.assasans.araumi.tx.server.ecs.events.IServerEvent
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1460106433434)
data class RestorePasswordByEmailEvent(
  val email: String
) : IServerEvent {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
    connection.player = Player(email.substringBefore('@'), email)

    connection.clientSession.addComponent(RestorePasswordCodeSentComponent(email))
  }
}
