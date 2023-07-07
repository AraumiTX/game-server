package jp.assasans.araumi.tx.server.ecs.events.user.friends

import jp.assasans.araumi.tx.server.ecs.events.IEvent
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1451120695251)
data class FriendsLoadedEvent(
    val acceptedFriendsIds: Set<Long>,
    val incomingFriendsIds: Set<Long>,
    val outgoingFriendsIds: Set<Long>
) : IEvent