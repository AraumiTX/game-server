package jp.assasans.araumi.tx.server.ecs.user

import jp.assasans.araumi.tx.server.ecs.IComponent
import jp.assasans.araumi.tx.server.protocol.ProtocolId
import jp.assasans.araumi.tx.server.protocol.ProtocolName

@ProtocolId(-5477085396086342998)
data class UserUidComponent(
  @ProtocolName("uid") val username: String
) : IComponent
