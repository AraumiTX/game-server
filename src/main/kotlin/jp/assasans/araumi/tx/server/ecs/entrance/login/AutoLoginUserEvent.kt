package jp.assasans.araumi.tx.server.ecs.entrance.login

import mu.KotlinLogging
import jp.assasans.araumi.tx.server.ecs.IEntity
import jp.assasans.araumi.tx.server.ecs.IServerEvent
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1438075609642)
data class AutoLoginUserEvent(
  val uid: String,
  val encryptedToken: ByteArray,
  val hardwareFingerprint: String
) : IServerEvent {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
    val logger = KotlinLogging.logger { }
    val (clientSession) = entities

    // TODO
    clientSession.send(AutoLoginFailedEvent())
  }
}
