package jp.assasans.araumi.tx.server.ecs.events.entrance.login

import jp.assasans.araumi.tx.server.ecs.events.IEvent
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1439531278716)
data class PersonalPasscodeEvent(val passcode: String) : IEvent
