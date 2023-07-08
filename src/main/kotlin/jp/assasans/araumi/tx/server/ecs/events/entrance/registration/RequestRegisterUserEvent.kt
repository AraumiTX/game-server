package jp.assasans.araumi.tx.server.ecs.events.entrance.registration

import mu.KotlinLogging
import jp.assasans.araumi.tx.server.ecs.Player
import jp.assasans.araumi.tx.server.ecs.entities.IEntity
import jp.assasans.araumi.tx.server.ecs.events.IServerEvent
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import jp.assasans.araumi.tx.server.network.send
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
    val logger = KotlinLogging.logger { }

    logger.debug { "Register player: $username" }

    if(username.contains("M8")) {
      connection.send(RegistrationFailedEvent())
      return
    }

    connection.player = Player(username, email).also { it.subscribed = subscribed }
    connection.register(username, encryptedPasswordDigest, email, hardwareFingerprint, subscribed, steam, quickRegistration)
  }
}
