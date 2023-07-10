package jp.assasans.araumi.tx.server.ecs.globalEntities

import kotlin.reflect.full.declaredMemberProperties
import jp.assasans.araumi.tx.server.ecs.components.group.MarketItemGroupComponent
import jp.assasans.araumi.tx.server.ecs.components.group.ParentGroupComponent
import jp.assasans.araumi.tx.server.ecs.components.item.DefaultSkinItemComponent
import jp.assasans.araumi.tx.server.ecs.components.user.UserGroupComponent
import jp.assasans.araumi.tx.server.ecs.entities.IEntity
import jp.assasans.araumi.tx.server.ecs.entities.component
import jp.assasans.araumi.tx.server.ecs.entities.entity
import jp.assasans.araumi.tx.server.ecs.entities.templateAccessor
import jp.assasans.araumi.tx.server.ecs.entities.templates.weapons.market.WeaponSkinMarketItemTemplate
import jp.assasans.araumi.tx.server.ecs.entities.templates.weapons.user.WeaponSkinUserItemTemplate
import jp.assasans.araumi.tx.server.network.IPlayerConnection

@Suppress("ObjectPropertyName", "SpellCheckingInspection")
object WeaponSkins : IUserGlobalEntities {
  override fun getUserTemplateItems(player: IPlayerConnection) =
    WeaponSkins::class.declaredMemberProperties
      .map { (it.get(this) as IEntity).clone() }
      .onEach {
        it.templateAccessor!!.template = WeaponSkinUserItemTemplate()

        // todo check if user has this item
        it.addComponent(UserGroupComponent(player.user.id))
      }

  val FlamethrowerDreadnought = entity(602602131) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/flamethrower/Dreadnought")
    component(ParentGroupComponent(Weapons.Flamethrower))
    component(MarketItemGroupComponent(602602131))
  }

  val FlamethrowerM0 = entity(2078566312) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/flamethrower/m0")
    component(ParentGroupComponent(Weapons.Flamethrower))
    component(MarketItemGroupComponent(2078566312))
    component(DefaultSkinItemComponent())
  }

  val FlamethrowerM1 = entity(2078566313) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/flamethrower/m1")
    component(ParentGroupComponent(Weapons.Flamethrower))
    component(MarketItemGroupComponent(2078566313))
  }

  val FlamethrowerM1gold = entity(1491390890) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/flamethrower/m1gold")
    component(ParentGroupComponent(Weapons.Flamethrower))
    component(MarketItemGroupComponent(1491390890))
  }

  val FlamethrowerM1steel = entity(-1000298047) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/flamethrower/m1steel")
    component(ParentGroupComponent(Weapons.Flamethrower))
    component(MarketItemGroupComponent(-1000298047))
  }

  val FlamethrowerM2 = entity(1045726795) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/flamethrower/m2")
    component(ParentGroupComponent(Weapons.Flamethrower))
    component(MarketItemGroupComponent(1045726795))
  }

  val FlamethrowerM2flame = entity(-983916600) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/flamethrower/m2flame")
    component(ParentGroupComponent(Weapons.Flamethrower))
    component(MarketItemGroupComponent(-983916600))
  }

  val FreezeM0 = entity(-472765007) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/freeze/m0")
    component(ParentGroupComponent(Weapons.Freeze))
    component(MarketItemGroupComponent(-472765007))
    component(DefaultSkinItemComponent())
  }

  val FreezeM1 = entity(-472765006) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/freeze/m1")
    component(ParentGroupComponent(Weapons.Freeze))
    component(MarketItemGroupComponent(-472765006))
  }

  val FreezeM1gold = entity(-362162189) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/freeze/m1gold")
    component(ParentGroupComponent(Weapons.Freeze))
    component(MarketItemGroupComponent(-362162189))
  }

  val FreezeM1steel = entity(1669098648) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/freeze/m1steel")
    component(ParentGroupComponent(Weapons.Freeze))
    component(MarketItemGroupComponent(1669098648))
  }

  val FreezeM2 = entity(237598868) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/freeze/m2")
    component(ParentGroupComponent(Weapons.Freeze))
    component(MarketItemGroupComponent(237598868))
  }

  val FreezeXmas = entity(139596834) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/freeze/xmas")
    component(ParentGroupComponent(Weapons.Freeze))
    component(MarketItemGroupComponent(139596834))
  }

  val HammerCry = entity(283356827) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/hammer/cry")
    component(ParentGroupComponent(Weapons.Hammer))
    component(MarketItemGroupComponent(283356827))
  }

  val HammerCrydischarge = entity(-350323544) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/hammer/crydischarge")
    component(ParentGroupComponent(Weapons.Hammer))
    component(MarketItemGroupComponent(-350323544))
  }

  val HammerCryglow = entity(-350323543) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/hammer/cryglow")
    component(ParentGroupComponent(Weapons.Hammer))
    component(MarketItemGroupComponent(-350323543))
  }

  val HammerCryrage = entity(-350323545) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/hammer/cryrage")
    component(ParentGroupComponent(Weapons.Hammer))
    component(MarketItemGroupComponent(-350323545))
  }

  val HammerM0 = entity(-635589854) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/hammer/m0")
    component(ParentGroupComponent(Weapons.Hammer))
    component(MarketItemGroupComponent(-635589854))
    component(DefaultSkinItemComponent())
  }

  val HammerM1 = entity(-635589853) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/hammer/m1")
    component(ParentGroupComponent(Weapons.Hammer))
    component(MarketItemGroupComponent(-635589853))
  }

  val HammerM1gold = entity(-1427688220) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/hammer/m1gold")
    component(ParentGroupComponent(Weapons.Hammer))
    component(MarketItemGroupComponent(-1427688220))
  }

  val HammerM1steel = entity(2039676487) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/hammer/m1steel")
    component(ParentGroupComponent(Weapons.Hammer))
    component(MarketItemGroupComponent(2039676487))
  }

  val HammerM2 = entity(1076729477) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/hammer/m2")
    component(ParentGroupComponent(Weapons.Hammer))
    component(MarketItemGroupComponent(1076729477))
  }

  val Isis8march2017 = entity(-305773183) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/isis/8march2017")
    component(ParentGroupComponent(Weapons.Isis))
    component(MarketItemGroupComponent(-305773183))
  }

  val IsisM0 = entity(-746649388) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/isis/m0")
    component(ParentGroupComponent(Weapons.Isis))
    component(MarketItemGroupComponent(-746649388))
    component(DefaultSkinItemComponent())
  }

  val IsisM1 = entity(-746649387) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/isis/m1")
    component(ParentGroupComponent(Weapons.Isis))
    component(MarketItemGroupComponent(-746649387))
  }

  val IsisM1gold = entity(-1704481322) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/isis/m1gold")
    component(ParentGroupComponent(Weapons.Isis))
    component(MarketItemGroupComponent(-1704481322))
  }

  val IsisM1steel = entity(-691629355) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/isis/m1steel")
    component(ParentGroupComponent(Weapons.Isis))
    component(MarketItemGroupComponent(-691629355))
  }

  val IsisM2 = entity(765745271) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/isis/m2")
    component(ParentGroupComponent(Weapons.Isis))
    component(MarketItemGroupComponent(765745271))
  }

  val RailgunM0 = entity(599453582) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/railgun/m0")
    component(ParentGroupComponent(Weapons.Railgun))
    component(MarketItemGroupComponent(599453582))
    component(DefaultSkinItemComponent())
  }

  val RailgunM1 = entity(599453583) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/railgun/m1")
    component(ParentGroupComponent(Weapons.Railgun))
    component(MarketItemGroupComponent(599453583))
  }

  val RailgunM1gold = entity(-1704191570) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/railgun/m1gold")
    component(ParentGroupComponent(Weapons.Railgun))
    component(MarketItemGroupComponent(-1704191570))
  }

  val RailgunM1steel = entity(-59670077) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/railgun/m1steel")
    component(ParentGroupComponent(Weapons.Railgun))
    component(MarketItemGroupComponent(-59670077))
  }

  val RailgunM2 = entity(599479587) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/railgun/m2")
    component(ParentGroupComponent(Weapons.Railgun))
    component(MarketItemGroupComponent(599479587))
  }

  val RailgunM2tsk = entity(254111980) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/railgun/m2tsk")
    component(ParentGroupComponent(Weapons.Railgun))
    component(MarketItemGroupComponent(254111980))
  }

  val RailgunMay2017 = entity(98615071) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/railgun/may2017")
    component(ParentGroupComponent(Weapons.Railgun))
    component(MarketItemGroupComponent(98615071))
  }

  val RailgunXt = entity(593679593) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/railgun/xt")
    component(ParentGroupComponent(Weapons.Railgun))
    component(MarketItemGroupComponent(593679593))
  }

  val RailgunXt_thor = entity(1793185296) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/railgun/xt_thor")
    component(ParentGroupComponent(Weapons.Railgun))
    component(MarketItemGroupComponent(1793185296))
  }

  val RicochetFrontierzero = entity(1077283204) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/ricochet/frontierzero")
    component(ParentGroupComponent(Weapons.Ricochet))
    component(MarketItemGroupComponent(1077283204))
  }

  val RicochetM0 = entity(-909167727) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/ricochet/m0")
    component(ParentGroupComponent(Weapons.Ricochet))
    component(MarketItemGroupComponent(-909167727))
    component(DefaultSkinItemComponent())
  }

  val RicochetM1 = entity(-909167726) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/ricochet/m1")
    component(ParentGroupComponent(Weapons.Ricochet))
    component(MarketItemGroupComponent(-909167726))
  }

  val RicochetM1gold = entity(-475547245) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/ricochet/m1gold")
    component(ParentGroupComponent(Weapons.Ricochet))
    component(MarketItemGroupComponent(-475547245))
  }

  val RicochetM1steel = entity(-1849888712) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/ricochet/m1steel")
    component(ParentGroupComponent(Weapons.Ricochet))
    component(MarketItemGroupComponent(-1849888712))
  }

  val RicochetM2 = entity(-342766924) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/ricochet/m2")
    component(ParentGroupComponent(Weapons.Ricochet))
    component(MarketItemGroupComponent(-342766924))
  }

  val ShaftM0 = entity(1460259970) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/shaft/m0")
    component(ParentGroupComponent(Weapons.Shaft))
    component(MarketItemGroupComponent(1460259970))
    component(DefaultSkinItemComponent())
  }

  val ShaftM1 = entity(1460259971) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/shaft/m1")
    component(ParentGroupComponent(Weapons.Shaft))
    component(MarketItemGroupComponent(1460259971))
  }

  val ShaftM1gold = entity(54173794) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/shaft/m1gold")
    component(ParentGroupComponent(Weapons.Shaft))
    component(MarketItemGroupComponent(54173794))
  }

  val ShaftM1steel = entity(-445855153) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/shaft/m1steel")
    component(ParentGroupComponent(Weapons.Shaft))
    component(MarketItemGroupComponent(-445855153))
  }

  val ShaftM2 = entity(1099854083) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/shaft/m2")
    component(ParentGroupComponent(Weapons.Shaft))
    component(MarketItemGroupComponent(1099854083))
  }

  val ShaftT2 = entity(1099854300) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/shaft/t2")
    component(ParentGroupComponent(Weapons.Shaft))
    component(MarketItemGroupComponent(1099854300))
  }

  val Smoky23february2017 = entity(-1141123658) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/smoky/23february2017")
    component(ParentGroupComponent(Weapons.Smoky))
    component(MarketItemGroupComponent(-1141123658))
  }

  val SmokyM0 = entity(2008385753) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/smoky/m0")
    component(ParentGroupComponent(Weapons.Smoky))
    component(MarketItemGroupComponent(2008385753))
    component(DefaultSkinItemComponent())
  }

  val SmokyM1 = entity(2008385754) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/smoky/m1")
    component(ParentGroupComponent(Weapons.Smoky))
    component(MarketItemGroupComponent(2008385754))
  }

  val SmokyM1gold = entity(2004785941) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/smoky/m1gold")
    component(ParentGroupComponent(Weapons.Smoky))
    component(MarketItemGroupComponent(2004785941))
  }

  val SmokyM1steel = entity(-617862056) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/smoky/m1steel")
    component(ParentGroupComponent(Weapons.Smoky))
    component(MarketItemGroupComponent(-617862056))
  }

  val SmokyM2 = entity(1647979866) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/smoky/m2")
    component(ParentGroupComponent(Weapons.Smoky))
    component(MarketItemGroupComponent(1647979866))
  }

  val SmokyMay2017 = entity(-1398640396) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/smoky/may2017")
    component(ParentGroupComponent(Weapons.Smoky))
    component(MarketItemGroupComponent(-1398640396))
  }

  val SmokyXt = entity(1647980273) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/smoky/xt")
    component(ParentGroupComponent(Weapons.Smoky))
    component(MarketItemGroupComponent(1647980273))
  }

  val SmokyXt_thor = entity(295929829) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/smoky/xt_thor")
    component(ParentGroupComponent(Weapons.Smoky))
    component(MarketItemGroupComponent(295929829))
  }

  val ThunderDreadnought = entity(1770762539) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/thunder/dreadnought")
    component(ParentGroupComponent(Weapons.Thunder))
    component(MarketItemGroupComponent(1770762539))
  }

  val ThunderM0 = entity(1552497496) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/thunder/m0")
    component(ParentGroupComponent(Weapons.Thunder))
    component(MarketItemGroupComponent(1552497496))
    component(DefaultSkinItemComponent())
  }

  val ThunderM1 = entity(1552497497) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/thunder/m1")
    component(ParentGroupComponent(Weapons.Thunder))
    component(MarketItemGroupComponent(1552497497))
  }

  val ThunderM1gold = entity(-398757768) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/thunder/m1gold")
    component(ParentGroupComponent(Weapons.Thunder))
    component(MarketItemGroupComponent(-398757768))
  }

  val ThunderM1steel = entity(1754072121) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/thunder/m1steel")
    component(ParentGroupComponent(Weapons.Thunder))
    component(MarketItemGroupComponent(1754072121))
  }

  val ThunderM2 = entity(2097643731) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/thunder/m2")
    component(ParentGroupComponent(Weapons.Thunder))
    component(MarketItemGroupComponent(2097643731))
  }

  val ThunderMay2017 = entity(1912357269) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/thunder/may2017")
    component(ParentGroupComponent(Weapons.Thunder))
    component(MarketItemGroupComponent(1912357269))
  }

  val ThunderXt = entity(2097644138) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/thunder/xt")
    component(ParentGroupComponent(Weapons.Thunder))
    component(MarketItemGroupComponent(2097644138))
  }

  val ThunderXt_thor = entity(-688039802) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/thunder/xt_thor")
    component(ParentGroupComponent(Weapons.Thunder))
    component(MarketItemGroupComponent(-688039802))
  }

  val TwinsM0 = entity(1468232592) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/twins/m0")
    component(ParentGroupComponent(Weapons.Twins))
    component(MarketItemGroupComponent(1468232592))
    component(DefaultSkinItemComponent())
  }

  val TwinsM1 = entity(274558103) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/twins/m1")
    component(ParentGroupComponent(Weapons.Twins))
    component(MarketItemGroupComponent(274558103))
  }

  val TwinsM1gold = entity(-1595894991) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/twins/m1gold")
    component(ParentGroupComponent(Weapons.Twins))
    component(MarketItemGroupComponent(-1595894991))
  }

  val TwinsM1steel = entity(-58379936) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/twins/m1steel")
    component(ParentGroupComponent(Weapons.Twins))
    component(MarketItemGroupComponent(-58379936))
  }

  val TwinsM2 = entity(-788257966) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/twins/m2")
    component(ParentGroupComponent(Weapons.Twins))
    component(MarketItemGroupComponent(-788257966))
  }

  val TwinsSteam = entity(-1959015927) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/twins/steam")
    component(ParentGroupComponent(Weapons.Twins))
    component(MarketItemGroupComponent(-1959015927))
  }

  val TwinsXt = entity(-788257559) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/twins/xt")
    component(ParentGroupComponent(Weapons.Twins))
    component(MarketItemGroupComponent(-788257559))
  }

  val TwinsXt_thor = entity(855411949) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/twins/xt_thor")
    component(ParentGroupComponent(Weapons.Twins))
    component(MarketItemGroupComponent(855411949))
  }

  val VulcanCry = entity(-388976915) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/vulcan/cry")
    component(ParentGroupComponent(Weapons.Vulcan))
    component(MarketItemGroupComponent(-388976915))
  }

  val VulcanCrydischarge = entity(-785177863) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/vulcan/crydischarge")
    component(ParentGroupComponent(Weapons.Vulcan))
    component(MarketItemGroupComponent(-785177863))
  }

  val VulcanCryglow = entity(-1559746012) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/vulcan/cryglow")
    component(ParentGroupComponent(Weapons.Vulcan))
    component(MarketItemGroupComponent(-1559746012))
  }

  val VulcanCryrage = entity(-1560119161) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/vulcan/cryrage")
    component(ParentGroupComponent(Weapons.Vulcan))
    component(MarketItemGroupComponent(-1560119161))
  }

  val VulcanM0 = entity(-851288667) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/vulcan/m0")
    component(ParentGroupComponent(Weapons.Vulcan))
    component(MarketItemGroupComponent(-851288667))
    component(DefaultSkinItemComponent())
  }

  val VulcanM1 = entity(-851288666) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/vulcan/m1")
    component(ParentGroupComponent(Weapons.Vulcan))
    component(MarketItemGroupComponent(-851288666))
  }

  val VulcanM1gold = entity(1066986983) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/vulcan/m1gold")
    component(ParentGroupComponent(Weapons.Vulcan))
    component(MarketItemGroupComponent(1066986983))
  }

  val VulcanM1steel = entity(2065196452) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/vulcan/m1steel")
    component(ParentGroupComponent(Weapons.Vulcan))
    component(MarketItemGroupComponent(2065196452))
  }

  val VulcanM2 = entity(-140924792) {
    templateAccessor(WeaponSkinMarketItemTemplate(), "garage/skin/weapon/vulcan/m2")
    component(ParentGroupComponent(Weapons.Vulcan))
    component(MarketItemGroupComponent(-140924792))
  }
}
