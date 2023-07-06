package jp.assasans.araumi.tx.server.ecs.entrance.restorePassword

import jp.assasans.araumi.tx.server.ecs.IComponent
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1479198715562)
data class RestorePasswordCodeSentComponent(
    val email: String
) : IComponent