package jp.assasans.araumi.tx.server.ecs.user

import jp.assasans.araumi.tx.server.ecs.IEntityTemplate
import jp.assasans.araumi.tx.server.ecs.component
import jp.assasans.araumi.tx.server.ecs.entity
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1433752208915)
object UserTemplate : IEntityTemplate {
  fun create() = entity("") {
    component(UserComponent())
    component(UserOnlineComponent())
    component(UserUidComponent("Assasans"))
  }.also { it.addComponent(UserGroupComponent(it)) }
}
