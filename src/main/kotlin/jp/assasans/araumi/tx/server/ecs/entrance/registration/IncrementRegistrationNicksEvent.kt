package jp.assasans.araumi.tx.server.ecs.entrance.registration

import jp.assasans.araumi.tx.server.ecs.IEntity
import jp.assasans.araumi.tx.server.ecs.IServerEvent
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1453881244963)
data class IncrementRegistrationNicksEvent(val nick: String) : IServerEvent {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
    // TODO(Assasans): Statistics?
  }
}
