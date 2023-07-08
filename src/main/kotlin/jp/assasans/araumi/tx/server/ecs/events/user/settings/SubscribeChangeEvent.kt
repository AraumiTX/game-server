package jp.assasans.araumi.tx.server.ecs.events.user.settings

import jp.assasans.araumi.tx.server.ecs.components.user.UserSubscribeComponent
import jp.assasans.araumi.tx.server.ecs.entities.IEntity
import jp.assasans.araumi.tx.server.ecs.entities.removeComponent
import jp.assasans.araumi.tx.server.ecs.events.IServerEvent
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1482844606270)
data class SubscribeChangeEvent(
  val subscribed: Boolean
) : IServerEvent {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
    connection.player.subscribed = subscribed

    if(subscribed) connection.user.addComponent(UserSubscribeComponent(true))
    else connection.user.removeComponent<UserSubscribeComponent>()
  }
}
