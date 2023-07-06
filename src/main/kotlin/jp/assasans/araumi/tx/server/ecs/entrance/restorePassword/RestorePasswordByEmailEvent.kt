package jp.assasans.araumi.tx.server.ecs.entrance.restorePassword

import jp.assasans.araumi.tx.server.ecs.IEntity
import jp.assasans.araumi.tx.server.ecs.IServerEvent
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1460106433434)
data class RestorePasswordByEmailEvent(
    val email: String
) : IServerEvent {
    override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
        val (clientSession) = entities
        clientSession.addComponent(RestorePasswordCodeSentComponent(email))
    }
}