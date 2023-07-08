package jp.assasans.araumi.tx.server.ecs

import java.util.*
import kotlinx.datetime.Instant
import mu.KotlinLogging
import jp.assasans.araumi.tx.server.ecs.entities.IEntity

class Player(
  var username: String,
  var email: String = "none@gmail.com"
) {
  private val logger = KotlinLogging.logger { }

  val groups: EnumSet<PlayerGroup> = EnumSet.noneOf(PlayerGroup::class.java)

  var subscribed: Boolean = true
  var countryCode: String = "AE"

  var crystals: Long = 0
  var xCrystals: Long = 0

  var experience: Long = 0

  var registrationTime: Instant = Instant.DISTANT_PAST
  var lastLoginTime: Instant = Instant.DISTANT_PAST

  val presets: MutableList<IEntity> = mutableListOf()

  val acceptedFriendIds = mutableSetOf<Long>()
  val incomingFriendIds = mutableSetOf<Long>()
  val outgoingFriendIds = mutableSetOf<Long>()

  val blockedPlayerIds = mutableSetOf<Long>()
  val reportedPlayerIds = mutableSetOf<Long>()

  init {
    val admins = listOf("Assasans", "C6OI")

    if(admins.contains(username))
      groups.addAll(setOf(PlayerGroup.Admin, PlayerGroup.Moderator, PlayerGroup.Tester, PlayerGroup.Premium))
  }
}

enum class PlayerGroup {
  Admin,
  Moderator,
  Tester,
  Premium
}
