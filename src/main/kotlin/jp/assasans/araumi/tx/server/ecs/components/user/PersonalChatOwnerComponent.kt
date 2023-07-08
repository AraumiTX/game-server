package jp.assasans.araumi.tx.server.ecs.components.user

import jp.assasans.araumi.tx.server.ecs.components.IComponent
import jp.assasans.araumi.tx.server.protocol.ProtocolId
import jp.assasans.araumi.tx.server.protocol.ProtocolName

@ProtocolId(1513067769958)
data class PersonalChatOwnerComponent(
  @ProtocolName("ChatIs") val chatIds: List<Long>
) : IComponent
