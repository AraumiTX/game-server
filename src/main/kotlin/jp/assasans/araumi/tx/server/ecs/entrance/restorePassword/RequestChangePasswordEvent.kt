package jp.assasans.araumi.tx.server.ecs.entrance.restorePassword

import jp.assasans.araumi.tx.server.ecs.IEntity
import jp.assasans.araumi.tx.server.ecs.IServerEvent
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1460403525230)
data class RequestChangePasswordEvent(
    val passwordDigest: String,
    val hardwareFingerprint: String
) : IServerEvent {
    override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
        //todo Save and login
    }
}