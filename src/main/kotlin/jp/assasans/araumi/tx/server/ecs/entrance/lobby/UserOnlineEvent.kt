package jp.assasans.araumi.tx.server.ecs.entrance.lobby

import jp.assasans.araumi.tx.server.ecs.IEntity
import jp.assasans.araumi.tx.server.ecs.IServerEvent
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1507022246767)
class UserOnlineEvent : IServerEvent {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
    // TODO
  }
}
