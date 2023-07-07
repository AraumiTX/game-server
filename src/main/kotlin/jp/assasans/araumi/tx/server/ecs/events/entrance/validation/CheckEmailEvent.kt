package jp.assasans.araumi.tx.server.ecs.events.entrance.validation

import jp.assasans.araumi.tx.server.ecs.entities.IEntity
import jp.assasans.araumi.tx.server.ecs.events.IServerEvent
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(635906273125139964)
data class CheckEmailEvent(
  val email: String,
  val includeUnconfirmed: Boolean
) : IServerEvent {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
    val (clientSession) = entities

    when(email.substringBefore("@")) {
      "taken"   -> clientSession.send(EmailOccupiedEvent(email))
      "invalid" -> clientSession.send(EmailInvalidEvent(email))
      else      -> clientSession.send(EmailVacantEvent(email))
    }
  }
}
