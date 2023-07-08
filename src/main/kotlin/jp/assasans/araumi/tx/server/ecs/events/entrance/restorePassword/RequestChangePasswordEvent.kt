package jp.assasans.araumi.tx.server.ecs.events.entrance.restorePassword

import jp.assasans.araumi.tx.server.ecs.entities.IEntity
import jp.assasans.araumi.tx.server.ecs.events.IServerEvent
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1460403525230)
data class RequestChangePasswordEvent(
  val passwordDigest: String,
  val hardwareFingerprint: String
) : IServerEvent {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
    // todo Save

    connection.login(true, passwordDigest, hardwareFingerprint)
  }
}
