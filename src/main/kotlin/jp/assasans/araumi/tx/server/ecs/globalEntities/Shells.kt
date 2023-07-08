package jp.assasans.araumi.tx.server.ecs.globalEntities

import kotlin.reflect.full.declaredMemberProperties
import jp.assasans.araumi.tx.server.ecs.components.group.MarketItemGroupComponent
import jp.assasans.araumi.tx.server.ecs.components.group.ParentGroupComponent
import jp.assasans.araumi.tx.server.ecs.components.user.UserGroupComponent
import jp.assasans.araumi.tx.server.ecs.entities.IEntity
import jp.assasans.araumi.tx.server.ecs.entities.component
import jp.assasans.araumi.tx.server.ecs.entities.entity
import jp.assasans.araumi.tx.server.ecs.entities.templateAccessor
import jp.assasans.araumi.tx.server.ecs.entities.templates.weapons.market.ShellMarketItemTemplate
import jp.assasans.araumi.tx.server.ecs.entities.templates.weapons.user.ShellUserItemTemplate
import jp.assasans.araumi.tx.server.network.IPlayerConnection

@Suppress("ObjectPropertyName", "SpellCheckingInspection")
object Shells : IGlobalEntities {
  fun getUserTemplateItems(player: IPlayerConnection) =
    Shells::class.declaredMemberProperties
      .map { (it.get(this) as IEntity).clone() }
      .onEach {
        it.templateAccessor!!.template = ShellUserItemTemplate()

        // todo check if user has this item
        it.addComponent(UserGroupComponent(player.user.id))
      }

  val FlamethrowerAcid = entity(692677861) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/flamethrower/acid")
    component(ParentGroupComponent(Weapons.Flamethrower))
    component(MarketItemGroupComponent(692677861))
  }

  val FlamethrowerOrange = entity(357929046) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/flamethrower/orange")
    component(ParentGroupComponent(Weapons.Flamethrower))
    component(MarketItemGroupComponent(357929046))
  }

  val FlamethrowerRed = entity(-947470487) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/flamethrower/red")
    component(ParentGroupComponent(Weapons.Flamethrower))
    component(MarketItemGroupComponent(-947470487))
  }

  val FreezeIndigo = entity(224610499) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/freeze/indigo")
    component(ParentGroupComponent(Weapons.Freeze))
    component(MarketItemGroupComponent(224610499))
  }

  val FreezeSkyblue = entity(-1408603862) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/freeze/skyblue")
    component(ParentGroupComponent(Weapons.Freeze))
    component(MarketItemGroupComponent(-1408603862))
  }

  val FreezeWhite = entity(-395640808) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/freeze/white")
    component(ParentGroupComponent(Weapons.Freeze))
    component(MarketItemGroupComponent(-395640808))
  }

  val HammerPapercracker = entity(142652989) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/hammer/papercracker")
    component(ParentGroupComponent(Weapons.Hammer))
    component(MarketItemGroupComponent(142652989))
  }

  val HammerStandard = entity(530945311) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/hammer/standard")
    component(ParentGroupComponent(Weapons.Hammer))
    component(MarketItemGroupComponent(530945311))
  }

  val HammerThor = entity(1317881529) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/hammer/thor")
    component(ParentGroupComponent(Weapons.Hammer))
    component(MarketItemGroupComponent(1317881529))
  }

  val IsisEmerald = entity(2065928272) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/isis/emerald")
    component(ParentGroupComponent(Weapons.Isis))
    component(MarketItemGroupComponent(2065928272))
  }

  val IsisShine = entity(-132552041) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/isis/shine")
    component(ParentGroupComponent(Weapons.Isis))
    component(MarketItemGroupComponent(-132552041))
  }

  val IsisStandard = entity(48235025) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/isis/standard")
    component(ParentGroupComponent(Weapons.Isis))
    component(MarketItemGroupComponent(48235025))
  }

  val RailgunGlitch = entity(-1975536348) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/railgun/glitch")
    component(ParentGroupComponent(Weapons.Railgun))
    component(MarketItemGroupComponent(-1975536348))
  }

  val RailgunGloom = entity(-375403918) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/railgun/gloom")
    component(ParentGroupComponent(Weapons.Railgun))
    component(MarketItemGroupComponent(-375403918))
  }

  val RailgunGreen = entity(-660457061) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/railgun/green")
    component(ParentGroupComponent(Weapons.Railgun))
    component(MarketItemGroupComponent(-660457061))
  }

  val RailgunOrange = entity(1229590166) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/railgun/orange")
    component(ParentGroupComponent(Weapons.Railgun))
    component(MarketItemGroupComponent(1229590166))
  }

  val RailgunPaleblue = entity(366763244) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/railgun/paleblue")
    component(ParentGroupComponent(Weapons.Railgun))
    component(MarketItemGroupComponent(366763244))
  }

  val RailgunPurple = entity(1261498404) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/railgun/purple")
    component(ParentGroupComponent(Weapons.Railgun))
    component(MarketItemGroupComponent(1261498404))
  }

  val RailgunSmoke = entity(-1195981301) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/railgun/smoke")
    component(ParentGroupComponent(Weapons.Railgun))
    component(MarketItemGroupComponent(-1195981301))
  }

  val RicochetAcid = entity(-492753567) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/ricochet/acid")
    component(ParentGroupComponent(Weapons.Ricochet))
    component(MarketItemGroupComponent(-492753567))
  }

  val RicochetAurulent = entity(139800007) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/ricochet/aurulent")
    component(ParentGroupComponent(Weapons.Ricochet))
    component(MarketItemGroupComponent(139800007))
  }

  val RicochetCannonball = entity(-1899861235) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/ricochet/cannonball")
    component(ParentGroupComponent(Weapons.Ricochet))
    component(MarketItemGroupComponent(-1899861235))
  }

  val RicochetCoral = entity(577198848) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/ricochet/coral")
    component(ParentGroupComponent(Weapons.Ricochet))
    component(MarketItemGroupComponent(577198848))
  }

  val RicochetMoon = entity(-585038633) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/ricochet/moon")
    component(ParentGroupComponent(Weapons.Ricochet))
    component(MarketItemGroupComponent(-585038633))
  }

  val RicochetRicsnowball = entity(-1073342998) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/ricochet/ricsnowball")
    component(ParentGroupComponent(Weapons.Ricochet))
    component(MarketItemGroupComponent(-1073342998))
  }

  val ShaftBlue = entity(-1488314890) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/shaft/blue")
    component(ParentGroupComponent(Weapons.Shaft))
    component(MarketItemGroupComponent(-1488314890))
  }

  val ShaftLighting = entity(-250346840) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/shaft/lighting")
    component(ParentGroupComponent(Weapons.Shaft))
    component(MarketItemGroupComponent(-250346840))
  }

  val ShaftRed = entity(-47995019) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/shaft/red")
    component(ParentGroupComponent(Weapons.Shaft))
    component(MarketItemGroupComponent(-47995019))
  }

  val ShaftStandard = entity(70311513) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/shaft/standard")
    component(ParentGroupComponent(Weapons.Shaft))
    component(MarketItemGroupComponent(70311513))
  }

  val SmokyFumes = entity(860375257) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/smoky/fumes")
    component(ParentGroupComponent(Weapons.Smoky))
    component(MarketItemGroupComponent(860375257))
  }

  val SmokyLightning = entity(-1260549513) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/smoky/lightning")
    component(ParentGroupComponent(Weapons.Smoky))
    component(MarketItemGroupComponent(-1260549513))
  }

  val SmokyStandard = entity(-966935184) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/smoky/standard")
    component(ParentGroupComponent(Weapons.Smoky))
    component(MarketItemGroupComponent(-966935184))
  }

  val SmokyThermite = entity(-1165747871) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/smoky/thermite")
    component(ParentGroupComponent(Weapons.Smoky))
    component(MarketItemGroupComponent(-1165747871))
  }

  val ThunderDragon = entity(-1852311024) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/thunder/dragon")
    component(ParentGroupComponent(Weapons.Thunder))
    component(MarketItemGroupComponent(-1852311024))
  }

  val ThunderLightning = entity(794635633) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/thunder/lightning")
    component(ParentGroupComponent(Weapons.Thunder))
    component(MarketItemGroupComponent(794635633))
  }

  val ThunderStandard = entity(1067800943) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/thunder/standard")
    component(ParentGroupComponent(Weapons.Thunder))
    component(MarketItemGroupComponent(1067800943))
  }

  val TwinsBlue = entity(807172229) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/twins/blue")
    component(ParentGroupComponent(Weapons.Twins))
    component(MarketItemGroupComponent(807172229))
  }

  val TwinsOrange = entity(-1319432295) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/twins/orange")
    component(ParentGroupComponent(Weapons.Twins))
    component(MarketItemGroupComponent(-1319432295))
  }

  val TwinsTurquoise = entity(-1173768746) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/twins/turquoise")
    component(ParentGroupComponent(Weapons.Twins))
    component(MarketItemGroupComponent(-1173768746))
  }

  val TwinsTwinssnowball = entity(-1092514341) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/twins/twinssnowball")
    component(ParentGroupComponent(Weapons.Twins))
    component(MarketItemGroupComponent(-1092514341))
  }

  val TwinsViolet = entity(-1126924822) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/twins/violet")
    component(ParentGroupComponent(Weapons.Twins))
    component(MarketItemGroupComponent(-1126924822))
  }

  val TwinsWhite = entity(-728200866) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/twins/white")
    component(ParentGroupComponent(Weapons.Twins))
    component(MarketItemGroupComponent(-728200866))
  }

  val VulcanAcid = entity(189181410) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/vulcan/acid")
    component(ParentGroupComponent(Weapons.Vulcan))
    component(MarketItemGroupComponent(189181410))
  }

  val VulcanBlue = entity(189220223) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/vulcan/blue")
    component(ParentGroupComponent(Weapons.Vulcan))
    component(MarketItemGroupComponent(189220223))
  }

  val VulcanRed = entity(-963712308) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/vulcan/red")
    component(ParentGroupComponent(Weapons.Vulcan))
    component(MarketItemGroupComponent(-963712308))
  }

  val VulcanStandard = entity(1322064226) {
    templateAccessor(ShellMarketItemTemplate(), "garage/shell/vulcan/standard")
    component(ParentGroupComponent(Weapons.Vulcan))
    component(MarketItemGroupComponent(1322064226))
  }


}
