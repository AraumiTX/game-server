package jp.assasans.araumi.tx.server.ecs.entrance.validation

import jp.assasans.araumi.tx.server.ecs.IEvent
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1460402823575)
data class RestorePasswordCodeInvalidEvent(
    val code: String
) : IEvent
