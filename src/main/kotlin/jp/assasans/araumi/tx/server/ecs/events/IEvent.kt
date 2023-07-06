package jp.assasans.araumi.tx.server.ecs.events

import jp.assasans.araumi.tx.server.ecs.entities.IEntity
import jp.assasans.araumi.tx.server.network.IPlayerConnection

interface IEvent
interface IServerEvent : IEvent {
  suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>)
}
