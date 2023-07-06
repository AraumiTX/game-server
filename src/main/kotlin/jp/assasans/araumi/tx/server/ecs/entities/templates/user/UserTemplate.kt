package jp.assasans.araumi.tx.server.ecs.entities.templates.user

import jp.assasans.araumi.tx.server.ecs.Player
import jp.assasans.araumi.tx.server.ecs.components.user.*
import jp.assasans.araumi.tx.server.ecs.entities.component
import jp.assasans.araumi.tx.server.ecs.entities.templates.IEntityTemplate
import jp.assasans.araumi.tx.server.ecs.entities.templates.entity
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1433752208915)
object UserTemplate : IEntityTemplate {
  fun create(player: Player) = entity("") {
    component(UserComponent())
    component(UserOnlineComponent())
    component(UserUidComponent(player.username))
    component(UserExperienceComponent(768800))
    component(UserRankComponent(63))
  }.also { it.addComponent(UserGroupComponent(it)) }
}
