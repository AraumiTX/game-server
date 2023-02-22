package jp.assasans.araumi.tx.server.ecs.entrance.login

import jp.assasans.araumi.tx.server.ecs.IServerEvent

abstract class IntroduceUserEvent(
  val captcha: String?
) : IServerEvent
