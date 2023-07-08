package jp.assasans.araumi.tx.server.ecs.events.entrance.registration

import jp.assasans.araumi.tx.server.ecs.events.IEvent
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1438592306427)
class RegistrationFailedEvent : IEvent
// Client-side bug: missing [JoinAll] in the signature of [RegistrationScreenSystem#UnlockScreenOnFail]
// Fixed in https://github.com/AraumiTX/game-resources/commit/ce39b9b
