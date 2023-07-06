package jp.assasans.araumi.tx.server.ecs

import java.util.*
import mu.KotlinLogging

class Player(
  val username: String,
) {
  private val logger = KotlinLogging.logger { }

  val groups: EnumSet<PlayerGroup> = EnumSet.noneOf(PlayerGroup::class.java)

  val acceptedFriendsIds = mutableSetOf<Long>()
  val incomingFriendsIds = mutableSetOf<Long>()
  val outgoingFriendsIds = mutableSetOf<Long>()
}

enum class PlayerGroup {
  Admin,
  Moderator,
  Tester,
  Premium
}
