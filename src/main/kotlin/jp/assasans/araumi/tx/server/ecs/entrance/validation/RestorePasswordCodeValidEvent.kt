package jp.assasans.araumi.tx.server.ecs.entrance.validation

import jp.assasans.araumi.tx.server.ecs.IEvent
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1460402875430)
data class RestorePasswordCodeValidEvent(
    val code: String
) : IEvent
