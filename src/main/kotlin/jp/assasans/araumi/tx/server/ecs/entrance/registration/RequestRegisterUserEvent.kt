package jp.assasans.araumi.tx.server.ecs.entrance.registration

import jp.assasans.araumi.tx.server.ecs.IEntity
import jp.assasans.araumi.tx.server.ecs.IServerEvent
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import jp.assasans.araumi.tx.server.protocol.ProtocolId
import jp.assasans.araumi.tx.server.protocol.ProtocolName

@ProtocolId(1438590245672)
data class RequestRegisterUserEvent(
  @ProtocolName("uid") val username: String,
  val encryptedPasswordDigest: String,
  val email: String,
  val hardwareFingerprint: String,
  val subscribed: Boolean,
  val steam: Boolean,
  val quickRegistration: Boolean
) : IServerEvent {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
    val (clientSession) = entities

    // Client-side bug: missing [JoinAll] in the signature of [RegistrationScreenSystem#UnlockScreenOnFail]
    clientSession.send(RegistrationFailedEvent())
  }
}
