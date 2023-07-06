package jp.assasans.araumi.tx.server.ecs.entities.templates.entrance

import jp.assasans.araumi.tx.server.ecs.components.entrance.ClientSessionComponent
import jp.assasans.araumi.tx.server.ecs.components.entrance.SessionSecurityPublicComponent
import jp.assasans.araumi.tx.server.ecs.components.entrance.invite.InviteComponent
import jp.assasans.araumi.tx.server.ecs.entities.component
import jp.assasans.araumi.tx.server.ecs.entities.templates.IEntityTemplate
import jp.assasans.araumi.tx.server.ecs.entities.templates.entity
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1429771189777)
object ClientSessionTemplate : IEntityTemplate {
  fun create() = entity(null) {
    component(ClientSessionComponent())
    component(SessionSecurityPublicComponent("AKhRLW42cTisWpRwUs3EfgLbs1xj32NVOEPwzMUdQiAHWEowCbIBSi0W45P550kTy0U6WKLl3MfFC+bTZ6voG15d:AQAB"))
    component(InviteComponent(inviteCode = null, showScreenOnEntrance = false))
  }
}
