package jp.assasans.araumi.tx.server.ecs.entrance

import jp.assasans.araumi.tx.server.ecs.IEntityTemplate
import jp.assasans.araumi.tx.server.ecs.component
import jp.assasans.araumi.tx.server.ecs.entity
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1429771189777)
object ClientSessionTemplate : IEntityTemplate {
  fun create() = entity(null) {
    component(ClientSessionComponent())
    component(SessionSecurityPublicComponent("AKhRLW42cTisWpRwUs3EfgLbs1xj32NVOEPwzMUdQiAHWEowCbIBSi0W45P550kTy0U6WKLl3MfFC+bTZ6voG15d:AQAB"))
  }
}
