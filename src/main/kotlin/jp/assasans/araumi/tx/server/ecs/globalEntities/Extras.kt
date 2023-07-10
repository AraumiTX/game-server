package jp.assasans.araumi.tx.server.ecs.globalEntities

import kotlin.reflect.full.declaredMemberProperties
import jp.assasans.araumi.tx.server.ecs.components.group.MarketItemGroupComponent
import jp.assasans.araumi.tx.server.ecs.components.item.MountedItemComponent
import jp.assasans.araumi.tx.server.ecs.components.item.UserItemCounterComponent
import jp.assasans.araumi.tx.server.ecs.components.item.preset.PresetNameComponent
import jp.assasans.araumi.tx.server.ecs.components.user.UserGroupComponent
import jp.assasans.araumi.tx.server.ecs.entities.IEntity
import jp.assasans.araumi.tx.server.ecs.entities.component
import jp.assasans.araumi.tx.server.ecs.entities.entity
import jp.assasans.araumi.tx.server.ecs.entities.templateAccessor
import jp.assasans.araumi.tx.server.ecs.entities.templates.golds.user.GoldBonusUserItemTemplate
import jp.assasans.araumi.tx.server.ecs.entities.templates.money.user.CrystalUserItemTemplate
import jp.assasans.araumi.tx.server.ecs.entities.templates.money.user.XCrystalUserItemTemplate
import jp.assasans.araumi.tx.server.ecs.entities.templates.presets.user.PresetUserItemTemplate
import jp.assasans.araumi.tx.server.network.IPlayerConnection

@Suppress("ObjectPropertyName", "SpellCheckingInspection")
object Extras : IUserGlobalEntities {
  override fun getUserTemplateItems(player: IPlayerConnection) =
    Extras::class.declaredMemberProperties
      .map { (it.get(this) as IEntity).clone() }
      .onEach {
        when(it.templateAccessor!!.template) {
          is GoldBonusUserItemTemplate ->
            it.addComponent(UserItemCounterComponent(player.player.goldBoxItems.toLong()))
        }

        it.addComponent(UserGroupComponent(player.user.id))
      }

  val Goldbonus = entity {
    templateAccessor(GoldBonusUserItemTemplate(), "garage/goldbonus")
    component(MarketItemGroupComponent(636909271))
  }

  val Crystal = entity {
    templateAccessor(CrystalUserItemTemplate(), "garage/crystal")
    component(MarketItemGroupComponent(1317350822))
    component(UserItemCounterComponent(0))
  }

  val Xcrystal = entity {
    templateAccessor(XCrystalUserItemTemplate(), "garage/xcrystal")
    component(MarketItemGroupComponent(947348559))
    component(UserItemCounterComponent(0))
  }

  val Preset = entity {
    templateAccessor(PresetUserItemTemplate(), "garage/preset")
    component(MarketItemGroupComponent(-571744569))
    component(PresetNameComponent("Preset 1"))
    component(MountedItemComponent())
  }
}
