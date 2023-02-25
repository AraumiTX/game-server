package jp.assasans.araumi.tx.server.ecs.entrance.login

import mu.KotlinLogging
import jp.assasans.araumi.tx.server.ecs.IEntity
import jp.assasans.araumi.tx.server.ecs.IServerEvent
import jp.assasans.araumi.tx.server.ecs.getComponent
import jp.assasans.araumi.tx.server.ecs.user.UserGroupComponent
import jp.assasans.araumi.tx.server.ecs.user.UserTemplate
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import jp.assasans.araumi.tx.server.network.share
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1437480091995)
data class LoginByPasswordEvent(
  val passwordEncipher: String,
  val rememberMe: Boolean,
  val hardwareFingerprint: String
) : IServerEvent {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
    val logger = KotlinLogging.logger { }
    val (clientSession) = entities

    if(rememberMe) {
      clientSession.send(SaveAutoLoginTokenEvent(username = "Assasans", token = ByteArray(32)))
    }

    val user = UserTemplate.create()
    connection.share(user)
    clientSession.addComponent(user.getComponent<UserGroupComponent>())
  }
}
