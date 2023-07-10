package jp.assasans.araumi.tx.server.ecs.globalEntities

import kotlin.reflect.full.declaredMemberProperties
import jp.assasans.araumi.tx.server.ecs.components.group.MarketItemGroupComponent
import jp.assasans.araumi.tx.server.ecs.components.group.ParentGroupComponent
import jp.assasans.araumi.tx.server.ecs.components.user.UserGroupComponent
import jp.assasans.araumi.tx.server.ecs.entities.IEntity
import jp.assasans.araumi.tx.server.ecs.entities.component
import jp.assasans.araumi.tx.server.ecs.entities.entity
import jp.assasans.araumi.tx.server.ecs.entities.templateAccessor
import jp.assasans.araumi.tx.server.ecs.entities.templates.hulls.market.TankMarketItemTemplate
import jp.assasans.araumi.tx.server.ecs.entities.templates.hulls.user.TankUserItemTemplate
import jp.assasans.araumi.tx.server.network.IPlayerConnection

@Suppress("ObjectPropertyName", "SpellCheckingInspection")
object Hulls : IUserGlobalEntities {
  override fun getUserTemplateItems(player: IPlayerConnection) =
    Hulls::class.declaredMemberProperties
      .map { (it.get(this) as IEntity).clone() }
      .onEach {
        it.templateAccessor!!.template = TankUserItemTemplate()

        // todo check if user has this item
        it.addComponent(UserGroupComponent(player.user.id))

        // todo experience
      }

  fun getDefaultSkins() = mapOf(
    (Dictator to HullSkins.DictatorM0),
    (Hornet to HullSkins.HornetM0),
    (Hunter to HullSkins.HunterM0),
    (Mammoth to HullSkins.MammothM0),
    (Titan to HullSkins.TitanM0),
    (Viking to HullSkins.VikingM0),
    (Wasp to HullSkins.WaspM0)
  )

  val Dictator = entity(655588521) {
    templateAccessor(TankMarketItemTemplate(), "garage/tank/dictator")
    component(ParentGroupComponent(655588521))
    component(MarketItemGroupComponent(655588521))
  }

  val Hornet = entity(532353871) {
    templateAccessor(TankMarketItemTemplate(), "garage/tank/hornet")
    component(ParentGroupComponent(532353871))
    component(MarketItemGroupComponent(532353871))
  }

  val Hunter = entity(537781597) {
    templateAccessor(TankMarketItemTemplate(), "garage/tank/hunter")
    component(ParentGroupComponent(537781597))
    component(MarketItemGroupComponent(537781597))
  }

  val Mammoth = entity(-939793870) {
    templateAccessor(TankMarketItemTemplate(), "garage/tank/mammoth")
    component(ParentGroupComponent(-939793870))
    component(MarketItemGroupComponent(-939793870))
  }

  val Titan = entity(-803206257) {
    templateAccessor(TankMarketItemTemplate(), "garage/tank/titan")
    component(ParentGroupComponent(-803206257))
    component(MarketItemGroupComponent(-803206257))
  }

  val Viking = entity(927407783) {
    templateAccessor(TankMarketItemTemplate(), "garage/tank/viking")
    component(ParentGroupComponent(927407783))
    component(MarketItemGroupComponent(927407783))
  }

  val Wasp = entity(1913834436) {
    templateAccessor(TankMarketItemTemplate(), "garage/tank/wasp")
    component(ParentGroupComponent(1913834436))
    component(MarketItemGroupComponent(1913834436))
  }
}
