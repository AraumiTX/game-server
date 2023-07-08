package jp.assasans.araumi.tx.server.ecs.components.fraction

import jp.assasans.araumi.tx.server.ecs.components.IComponent
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1544956558339)
data class RestrictionByUserFractionComponent(
  var fractionId: Long = 0
) : IComponent
