package jp.assasans.araumi.tx.server.ecs.entrance.validation

import jp.assasans.araumi.tx.server.ecs.IEntity
import jp.assasans.araumi.tx.server.ecs.IServerEvent
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import jp.assasans.araumi.tx.server.protocol.ProtocolId
import jp.assasans.araumi.tx.server.protocol.ProtocolName

@ProtocolId(1437990639822)
data class CheckUserUidEvent(
  @ProtocolName("uid") val username: String
) : IServerEvent {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
    val (clientSession) = entities

    if(username != "taken") {
      clientSession.send(UserUidVacantEvent(username))
    } else {
      clientSession.send(UserUidOccupiedEvent(username))
    }
  }
}
