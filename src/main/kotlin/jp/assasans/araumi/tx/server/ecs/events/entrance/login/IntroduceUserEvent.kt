package jp.assasans.araumi.tx.server.ecs.events.entrance.login

import jp.assasans.araumi.tx.server.ecs.events.IServerEvent

abstract class IntroduceUserEvent(
  val captcha: String?
) : IServerEvent
