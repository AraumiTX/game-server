package jp.assasans.araumi.tx.server.ecs.globalEntities

import jp.assasans.araumi.tx.server.ecs.components.group.MarketItemGroupComponent
import jp.assasans.araumi.tx.server.ecs.components.group.ParentGroupComponent
import jp.assasans.araumi.tx.server.ecs.components.user.UserGroupComponent
import jp.assasans.araumi.tx.server.ecs.entities.IEntity
import jp.assasans.araumi.tx.server.ecs.entities.component
import jp.assasans.araumi.tx.server.ecs.entities.entity
import jp.assasans.araumi.tx.server.ecs.entities.templateAccessor
import jp.assasans.araumi.tx.server.ecs.entities.templates.weapons.market.*
import jp.assasans.araumi.tx.server.ecs.entities.templates.weapons.user.*
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import kotlin.reflect.full.declaredMemberProperties

object Weapons : IGlobalEntities {
    fun getUserTemplateItems(player: IPlayerConnection) =
        Weapons::class.declaredMemberProperties
            .map { (it.get(this) as IEntity).clone() }
            .onEach {
                it.templateAccessor!!.template = when(it.templateAccessor!!.template) {
                    is FlamethrowerMarketItemTemplate -> FlamethrowerUserItemTemplate()
                    is FreezeMarketItemTemplate -> FreezeUserItemTemplate()
                    is HammerMarketItemTemplate -> HammerUserItemTemplate()
                    is IsisMarketItemTemplate -> IsisUserItemTemplate()
                    is RailgunMarketItemTemplate -> RailgunUserItemTemplate()
                    is RicochetMarketItemTemplate -> RicochetUserItemTemplate()
                    is ShaftMarketItemTemplate -> ShaftUserItemTemplate()
                    is SmokyMarketItemTemplate -> SmokyUserItemTemplate()
                    is ThunderMarketItemTemplate -> ThunderUserItemTemplate()
                    is TwinsMarketItemTemplate -> TwinsUserItemTemplate()
                    is VulcanMarketItemTemplate -> VulcanUserItemTemplate()
                    else -> throw UnsupportedOperationException("Unexpected template")
                }

                //todo check if user has this item
                it.addComponent(UserGroupComponent(player.user.id))

                //todo experience
            }

    val Flamethrower = entity(1021054379) {
        templateAccessor(FlamethrowerMarketItemTemplate(), "garage/weapon/flamethrower")
        component(ParentGroupComponent(1021054379))
        component(MarketItemGroupComponent(1021054379))
    }

    val Freeze = entity(1878479106) {
        templateAccessor(FreezeMarketItemTemplate(), "garage/weapon/freeze")
        component(ParentGroupComponent(1878479106))
        component(MarketItemGroupComponent(1878479106))
    }

    val Hammer = entity(1920282929) {
        templateAccessor(HammerMarketItemTemplate(), "garage/weapon/hammer")
        component(ParentGroupComponent(1920282929))
        component(MarketItemGroupComponent(1920282929))
    }

    val Isis = entity(1874668799) {
        templateAccessor(IsisMarketItemTemplate(), "garage/weapon/isis")
        component(ParentGroupComponent(1874668799))
        component(MarketItemGroupComponent(1874668799))
    }

    val Railgun = entity(-319390877) {
        templateAccessor(RailgunMarketItemTemplate(), "garage/weapon/railgun")
        component(ParentGroupComponent(-319390877))
        component(MarketItemGroupComponent(-319390877))
    }

    val Ricochet = entity(1324743394) {
        templateAccessor(RicochetMarketItemTemplate(), "garage/weapon/ricochet")
        component(ParentGroupComponent(1324743394))
        component(MarketItemGroupComponent(1324743394))
    }

    val Shaft = entity(-2005909841) {
        templateAccessor(ShaftMarketItemTemplate(), "garage/weapon/shaft")
        component(ParentGroupComponent(-2005909841))
        component(MarketItemGroupComponent(-2005909841))
    }

    val Smoky = entity(-2005747272) {
        templateAccessor(SmokyMarketItemTemplate(), "garage/weapon/smoky")
        component(ParentGroupComponent(-2005747272))
        component(MarketItemGroupComponent(-2005747272))
    }

    val Thunder = entity(1667159001) {
        templateAccessor(ThunderMarketItemTemplate(), "garage/weapon/thunder")
        component(ParentGroupComponent(1667159001))
        component(MarketItemGroupComponent(1667159001))
    }

    val Twins = entity(-2004531520) {
        templateAccessor(TwinsMarketItemTemplate(), "garage/weapon/twins")
        component(ParentGroupComponent(-2004531520))
        component(MarketItemGroupComponent(-2004531520))
    }

    val Vulcan = entity(-1955445362) {
        templateAccessor(VulcanMarketItemTemplate(), "garage/weapon/vulcan")
        component(ParentGroupComponent(-1955445362))
        component(MarketItemGroupComponent(-1955445362))
    }
}