package jp.assasans.araumi.tx.server.ecs.entrance.validation

import jp.assasans.araumi.tx.server.ecs.IEvent
import jp.assasans.araumi.tx.server.protocol.ProtocolId
import jp.assasans.araumi.tx.server.protocol.ProtocolName

@ProtocolId(1437991652726)
class UserUidOccupiedEvent(
  @ProtocolName("uid") val username: String
) : IEvent
