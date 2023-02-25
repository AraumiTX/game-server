package jp.assasans.araumi.tx.server.ecs.entrance.login

import jp.assasans.araumi.tx.server.ecs.IEvent
import jp.assasans.araumi.tx.server.protocol.ProtocolId
import jp.assasans.araumi.tx.server.protocol.ProtocolName

@ProtocolId(1438070264777)
data class SaveAutoLoginTokenEvent(
  @ProtocolName("uid") val username: String,
  val token: ByteArray
) : IEvent
