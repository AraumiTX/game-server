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
import jp.assasans.araumi.tx.server.ecs.entities.templates.hulls.market.HullSkinMarketItemTemplate
import jp.assasans.araumi.tx.server.ecs.entities.templates.hulls.user.HullSkinUserItemTemplate
import jp.assasans.araumi.tx.server.network.IPlayerConnection

@Suppress("ObjectPropertyName", "SpellCheckingInspection")
object HullSkins : IUserGlobalEntities {
  override fun getUserTemplateItems(player: IPlayerConnection) =
    HullSkins::class.declaredMemberProperties
      .map { (it.get(this) as IEntity).clone() }
      .onEach {
        it.templateAccessor!!.template = HullSkinUserItemTemplate()

        // todo check if user has this item
        it.addComponent(UserGroupComponent(player.user.id))
      }

  val DictatorDreadnought = entity(732611697) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/dictator/dreadnought")
    component(ParentGroupComponent(Hulls.Dictator))
    component(MarketItemGroupComponent(732611697))
  }

  val DictatorM0 = entity(-1555682652) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/dictator/m0")
    component(ParentGroupComponent(Hulls.Dictator))
    component(MarketItemGroupComponent(-1555682652))
    component(DefaultSkinItemComponent())
  }

  val DictatorM1 = entity(-1555682651) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/dictator/m1")
    component(ParentGroupComponent(Hulls.Dictator))
    component(MarketItemGroupComponent(-1555682651))
  }

  val DictatorM1gold = entity(-767847828) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/dictator/m1gold")
    component(ParentGroupComponent(Hulls.Dictator))
    component(MarketItemGroupComponent(-767847828))
  }

  val DictatorM1steel = entity(-1626035585) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/dictator/m1steel")
    component(ParentGroupComponent(Hulls.Dictator))
    component(MarketItemGroupComponent(-1626035585))
  }

  val DictatorM2 = entity(783713997) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/dictator/m2")
    component(ParentGroupComponent(Hulls.Dictator))
    component(MarketItemGroupComponent(783713997))
  }

  val DictatorM2flame = entity(1994127174) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/dictator/m2flame")
    component(ParentGroupComponent(Hulls.Dictator))
    component(MarketItemGroupComponent(1994127174))
  }

  val HornetCry = entity(1765925144) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/hornet/cry")
    component(ParentGroupComponent(Hulls.Hornet))
    component(MarketItemGroupComponent(1765925144))
  }

  val HornetCrydischarge = entity(-955210933) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/hornet/crydischarge")
    component(ParentGroupComponent(Hulls.Hornet))
    component(MarketItemGroupComponent(-955210933))
  }

  val HornetCryglow = entity(-955210932) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/hornet/cryglow")
    component(ParentGroupComponent(Hulls.Hornet))
    component(MarketItemGroupComponent(-955210932))
  }

  val HornetCryrage = entity(-955210934) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/hornet/cryrage")
    component(ParentGroupComponent(Hulls.Hornet))
    component(MarketItemGroupComponent(-955210934))
  }

  val HornetM0 = entity(-1194388226) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/hornet/m0")
    component(ParentGroupComponent(Hulls.Hornet))
    component(MarketItemGroupComponent(-1194388226))
    component(DefaultSkinItemComponent())
  }

  val HornetM1 = entity(-1194388225) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/hornet/m1")
    component(ParentGroupComponent(Hulls.Hornet))
    component(MarketItemGroupComponent(-1194388225))
  }

  val HornetM1gold = entity(679021958) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/hornet/m1gold")
    component(ParentGroupComponent(Hulls.Hornet))
    component(MarketItemGroupComponent(679021958))
  }

  val HornetM1steel = entity(-378883611) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/hornet/m1steel")
    component(ParentGroupComponent(Hulls.Hornet))
    component(MarketItemGroupComponent(-378883611))
  }

  val HornetM2 = entity(-1992749017) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/hornet/m2")
    component(ParentGroupComponent(Hulls.Hornet))
    component(MarketItemGroupComponent(-1992749017))
  }

  val HornetMay2017 = entity(963790407) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/hornet/may2017")
    component(ParentGroupComponent(Hulls.Hornet))
    component(MarketItemGroupComponent(963790407))
  }

  val HornetT0 = entity(-47777666) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/hornet/t0")
    component(ParentGroupComponent(Hulls.Hornet))
    component(MarketItemGroupComponent(-47777666))
  }

  val HornetT0gold = entity(-1475671586) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/hornet/t0gold")
    component(ParentGroupComponent(Hulls.Hornet))
    component(MarketItemGroupComponent(-1475671586))
  }

  val HornetXt = entity(-47777474) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/hornet/xt")
    component(ParentGroupComponent(Hulls.Hornet))
    component(MarketItemGroupComponent(-47777474))
  }

  val HornetXt_thor = entity(-1636606664) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/hornet/xt_thor")
    component(ParentGroupComponent(Hulls.Hornet))
    component(MarketItemGroupComponent(-1636606664))
  }

  val Hunter23february2017 = entity(247232443) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/hunter/23february2017")
    component(ParentGroupComponent(Hulls.Hunter))
    component(MarketItemGroupComponent(247232443))
  }

  val HunterM0 = entity(1589207088) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/hunter/m0")
    component(ParentGroupComponent(Hulls.Hunter))
    component(MarketItemGroupComponent(1589207088))
    component(DefaultSkinItemComponent())
  }

  val HunterM1 = entity(1589207089) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/hunter/m1")
    component(ParentGroupComponent(Hulls.Hunter))
    component(MarketItemGroupComponent(1589207089))
  }

  val HunterM1gold = entity(-318345288) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/hunter/m1gold")
    component(ParentGroupComponent(Hulls.Hunter))
    component(MarketItemGroupComponent(-318345288))
  }

  val HunterM1steel = entity(-1267544717) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/hunter/m1steel")
    component(ParentGroupComponent(Hulls.Hunter))
    component(MarketItemGroupComponent(-1267544717))
  }

  val HunterM2 = entity(1589207091) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/hunter/m2")
    component(ParentGroupComponent(Hulls.Hunter))
    component(MarketItemGroupComponent(1589207091))
  }

  val HunterMay2017 = entity(110176853) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/hunter/may2017")
    component(ParentGroupComponent(Hulls.Hunter))
    component(MarketItemGroupComponent(110176853))
  }

  val HunterXt = entity(790846704) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/hunter/xt")
    component(ParentGroupComponent(Hulls.Hunter))
    component(MarketItemGroupComponent(790846704))
  }

  val HunterXt_thor = entity(1804747078) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/hunter/xt_thor")
    component(ParentGroupComponent(Hulls.Hunter))
    component(MarketItemGroupComponent(1804747078))
  }

  val MammothM0 = entity(-543026971) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/mammoth/m0")
    component(ParentGroupComponent(Hulls.Mammoth))
    component(MarketItemGroupComponent(-543026971))
    component(DefaultSkinItemComponent())
  }

  val MammothM1 = entity(-543026970) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/mammoth/m1")
    component(ParentGroupComponent(Hulls.Mammoth))
    component(MarketItemGroupComponent(-543026970))
  }

  val MammothM1gold = entity(-920939649) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/mammoth/m1gold")
    component(ParentGroupComponent(Hulls.Mammoth))
    component(MarketItemGroupComponent(-920939649))
  }

  val MammothM1steel = entity(-833500654) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/mammoth/m1steel")
    component(ParentGroupComponent(Hulls.Mammoth))
    component(MarketItemGroupComponent(-833500654))
  }

  val MammothM2 = entity(-543026935) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/mammoth/m2")
    component(ParentGroupComponent(Hulls.Mammoth))
    component(MarketItemGroupComponent(-543026935))
  }

  val MammothSteam = entity(677046075) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/mammoth/steam")
    component(ParentGroupComponent(Hulls.Mammoth))
    component(MarketItemGroupComponent(677046075))
  }

  val TitanFrontierzero = entity(1470436461) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/titan/frontierzero")
    component(ParentGroupComponent(Hulls.Titan))
    component(MarketItemGroupComponent(1470436461))
  }

  val TitanM0 = entity(-1584239704) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/titan/m0")
    component(ParentGroupComponent(Hulls.Titan))
    component(MarketItemGroupComponent(-1584239704))
    component(DefaultSkinItemComponent())
  }

  val TitanM1 = entity(-1584239703) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/titan/m1")
    component(ParentGroupComponent(Hulls.Titan))
    component(MarketItemGroupComponent(-1584239703))
  }

  val TitanM1gold = entity(-754659582) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/titan/m1gold")
    component(ParentGroupComponent(Hulls.Titan))
    component(MarketItemGroupComponent(-754659582))
  }

  val TitanM1steel = entity(-133498961) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/titan/m1steel")
    component(ParentGroupComponent(Hulls.Titan))
    component(MarketItemGroupComponent(-133498961))
  }

  val TitanM2 = entity(-1584239766) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/titan/m2")
    component(ParentGroupComponent(Hulls.Titan))
    component(MarketItemGroupComponent(-1584239766))
  }

  val TitanM2tsk = entity(-651639290) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/titan/m2tsk")
    component(ParentGroupComponent(Hulls.Titan))
    component(MarketItemGroupComponent(-651639290))
  }

  val TitanXt = entity(1576595770) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/titan/xt")
    component(ParentGroupComponent(Hulls.Titan))
    component(MarketItemGroupComponent(1576595770))
  }

  val TitanXt_thor = entity(1163905852) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/titan/xt_thor")
    component(ParentGroupComponent(Hulls.Titan))
    component(MarketItemGroupComponent(1163905852))
  }

  val VikingCry = entity(-1353746752) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/viking/cry")
    component(ParentGroupComponent(Hulls.Viking))
    component(MarketItemGroupComponent(-1353746752))
  }

  val VikingCrydischarge = entity(-1363672965) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/viking/crydischarge")
    component(ParentGroupComponent(Hulls.Viking))
    component(MarketItemGroupComponent(-1363672965))
  }

  val VikingCryglow = entity(-110402718) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/viking/cryglow")
    component(ParentGroupComponent(Hulls.Viking))
    component(MarketItemGroupComponent(-110402718))
  }

  val VikingCryrage = entity(-110775867) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/viking/cryrage")
    component(ParentGroupComponent(Hulls.Viking))
    component(MarketItemGroupComponent(-110775867))
  }

  val VikingM0 = entity(-353686874) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/viking/m0")
    component(ParentGroupComponent(Hulls.Viking))
    component(MarketItemGroupComponent(-353686874))
    component(DefaultSkinItemComponent())
  }

  val VikingM1 = entity(-353686873) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/viking/m1")
    component(ParentGroupComponent(Hulls.Viking))
    component(MarketItemGroupComponent(-353686873))
  }

  val VikingM1gold = entity(499257134) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/viking/m1gold")
    component(ParentGroupComponent(Hulls.Viking))
    component(MarketItemGroupComponent(499257134))
  }

  val VikingM1steel = entity(-1656625859) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/viking/m1steel")
    component(ParentGroupComponent(Hulls.Viking))
    component(MarketItemGroupComponent(-1656625859))
  }

  val VikingM2 = entity(792923471) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/viking/m2")
    component(ParentGroupComponent(Hulls.Viking))
    component(MarketItemGroupComponent(792923471))
  }

  val VikingMay2017 = entity(-313951841) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/viking/may2017")
    component(ParentGroupComponent(Hulls.Viking))
    component(MarketItemGroupComponent(-313951841))
  }

  val VikingT2 = entity(-1152047448) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/viking/t2")
    component(ParentGroupComponent(Hulls.Viking))
    component(MarketItemGroupComponent(-1152047448))
  }

  val VikingXt = entity(792923878) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/viking/xt")
    component(ParentGroupComponent(Hulls.Viking))
    component(MarketItemGroupComponent(792923878))
  }

  val VikingXt_thor = entity(1380618384) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/viking/xt_thor")
    component(ParentGroupComponent(Hulls.Viking))
    component(MarketItemGroupComponent(1380618384))
  }

  val Wasp8march2017 = entity(-1648311780) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/wasp/8march2017")
    component(ParentGroupComponent(Hulls.Wasp))
    component(MarketItemGroupComponent(-1648311780))
  }

  val WaspDreadnought = entity(-2009337684) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/wasp/Dreadnought")
    component(ParentGroupComponent(Hulls.Wasp))
    component(MarketItemGroupComponent(-2009337684))
  }

  val WaspM0 = entity(-1774581975) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/wasp/m0")
    component(ParentGroupComponent(Hulls.Wasp))
    component(MarketItemGroupComponent(-1774581975))
    component(DefaultSkinItemComponent())
  }

  val WaspM1 = entity(-1774581974) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/wasp/m1")
    component(ParentGroupComponent(Hulls.Wasp))
    component(MarketItemGroupComponent(-1774581974))
  }

  val WaspM1gold = entity(-1774441975) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/wasp/m1gold")
    component(ParentGroupComponent(Hulls.Wasp))
    component(MarketItemGroupComponent(-1774441975))
  }

  val WaspM1steel = entity(-1555805158) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/wasp/m1steel")
    component(ParentGroupComponent(Hulls.Wasp))
    component(MarketItemGroupComponent(-1555805158))
  }

  val WaspM2 = entity(-10051566) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/wasp/m2")
    component(ParentGroupComponent(Hulls.Wasp))
    component(MarketItemGroupComponent(-10051566))
  }

  val WaspXmas = entity(72041592) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/wasp/xmas")
    component(ParentGroupComponent(Hulls.Wasp))
    component(MarketItemGroupComponent(72041592))
  }

  val WaspXt = entity(-1129770519) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/wasp/xt")
    component(ParentGroupComponent(Hulls.Wasp))
    component(MarketItemGroupComponent(-1129770519))
  }

  val WaspXt_thor = entity(-1838544851) {
    templateAccessor(HullSkinMarketItemTemplate(), "garage/skin/tank/wasp/xt_thor")
    component(ParentGroupComponent(Hulls.Wasp))
    component(MarketItemGroupComponent(-1838544851))
  }
}
