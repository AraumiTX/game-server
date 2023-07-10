package jp.assasans.araumi.tx.server.ecs.events.entrance.lobby

import jp.assasans.araumi.tx.server.ecs.Preset
import jp.assasans.araumi.tx.server.ecs.components.item.MountedItemComponent
import jp.assasans.araumi.tx.server.ecs.components.user.UserAvatarComponent
import jp.assasans.araumi.tx.server.ecs.entities.IEntity
import jp.assasans.araumi.tx.server.ecs.events.IServerEvent
import jp.assasans.araumi.tx.server.ecs.events.payment.PaymentSectionLoadedEvent
import jp.assasans.araumi.tx.server.ecs.events.user.friends.FriendsLoadedEvent
import jp.assasans.araumi.tx.server.ecs.globalEntities.Avatars
import jp.assasans.araumi.tx.server.ecs.globalEntities.Extras
import jp.assasans.araumi.tx.server.ecs.globalEntities.GlobalEntities
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import jp.assasans.araumi.tx.server.network.share
import jp.assasans.araumi.tx.server.protocol.ProtocolId

@ProtocolId(1507022246767)
class UserOnlineEvent : IServerEvent {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
    // TODO(Assasans)

    connection.share(GlobalEntities.getAllUserTemplateItems(connection))

    connection.user.addComponent(UserAvatarComponent())

    connection.player.presets.clear()

    val presetEntity = connection.player.userTemplateItems[Extras::class]!!.single { it.id == Extras.Preset.id }
    val preset = Preset(connection, presetEntity)

    presetEntity.addComponent(preset.component)
    connection.player.presets.add(preset)

    (listOf(
      (connection.player.userTemplateItems[Avatars::class]!!.single { it.id == Avatars.MoroccoFlag.id }),
      connection.player.currentPreset.weaponItem,
      connection.player.currentPreset.hullItem,
      connection.player.currentPreset.paint,
      connection.player.currentPreset.coating,
      connection.player.currentPreset.graffiti
    ) +
     connection.player.currentPreset.hullSkins.values +
     connection.player.currentPreset.weaponSkins.values +
     connection.player.currentPreset.shells.values).forEach {
      it.addComponent(MountedItemComponent())
    }

    connection.clientSession.send(PaymentSectionLoadedEvent())
    connection.clientSession.send(FriendsLoadedEvent(connection.player.acceptedFriendIds, connection.player.incomingFriendIds, connection.player.outgoingFriendIds))
  }
}
