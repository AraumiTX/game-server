package jp.assasans.araumi.tx.server.ecs.events.entrance.invite

import jp.assasans.araumi.tx.server.ecs.components.entrance.invite.InviteComponent
import jp.assasans.araumi.tx.server.ecs.entities.IEntity
import jp.assasans.araumi.tx.server.ecs.entities.getComponent
import jp.assasans.araumi.tx.server.ecs.events.IServerEvent
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1439810001590)
class InviteEnteredEvent : IServerEvent {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
    val (clientSession) = entities

    val code = clientSession.getComponent<InviteComponent>().inviteCode
    if(code != "invalid") {
      clientSession.send(CommenceRegistrationEvent())
    } else {
      clientSession.send(InviteDoesNotExistEvent())
    }
  }
}
