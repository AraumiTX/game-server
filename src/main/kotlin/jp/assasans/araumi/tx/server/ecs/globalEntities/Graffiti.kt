package jp.assasans.araumi.tx.server.ecs.globalEntities

import kotlin.reflect.full.declaredMemberProperties
import jp.assasans.araumi.tx.server.ecs.components.fraction.RestrictionByUserFractionComponent
import jp.assasans.araumi.tx.server.ecs.components.group.MarketItemGroupComponent
import jp.assasans.araumi.tx.server.ecs.components.group.ParentGroupComponent
import jp.assasans.araumi.tx.server.ecs.components.user.UserGroupComponent
import jp.assasans.araumi.tx.server.ecs.entities.IEntity
import jp.assasans.araumi.tx.server.ecs.entities.component
import jp.assasans.araumi.tx.server.ecs.entities.entity
import jp.assasans.araumi.tx.server.ecs.entities.templateAccessor
import jp.assasans.araumi.tx.server.ecs.entities.templates.graffiti.market.ChildGraffitiMarketItemTemplate
import jp.assasans.araumi.tx.server.ecs.entities.templates.graffiti.market.GraffitiMarketItemTemplate
import jp.assasans.araumi.tx.server.ecs.entities.templates.graffiti.user.GraffitiUserItemTemplate
import jp.assasans.araumi.tx.server.network.IPlayerConnection

@Suppress("ObjectPropertyName", "SpellCheckingInspection")
object Graffiti : IGlobalEntities {
  fun getUserTemplateItems(player: IPlayerConnection) =
    Graffiti::class.declaredMemberProperties
      .map { (it.get(this) as IEntity).clone() }
      .onEach {
        it.templateAccessor!!.template = GraffitiUserItemTemplate()

        // todo check if user has this item
        it.addComponent(UserGroupComponent(player.user.id))
      }

  val Dictator = entity(-779102498) {
    templateAccessor(ChildGraffitiMarketItemTemplate(), "garage/graffiti/child/dictator")
    component(RestrictionByUserFractionComponent())
    component(ParentGroupComponent(Hulls.Dictator))
    component(MarketItemGroupComponent(-779102498))
  }

  val Flamethrower = entity(-1319913646) {
    templateAccessor(ChildGraffitiMarketItemTemplate(), "garage/graffiti/child/flamethrower")
    component(RestrictionByUserFractionComponent())
    component(ParentGroupComponent(Weapons.Flamethrower))
    component(MarketItemGroupComponent(-1319913646))
  }

  val Freeze = entity(1530725353) {
    templateAccessor(ChildGraffitiMarketItemTemplate(), "garage/graffiti/child/freeze")
    component(RestrictionByUserFractionComponent())
    component(ParentGroupComponent(Weapons.Freeze))
    component(MarketItemGroupComponent(1530725353))
  }

  val Hammer = entity(1590999596) {
    templateAccessor(ChildGraffitiMarketItemTemplate(), "garage/graffiti/child/hammer")
    component(RestrictionByUserFractionComponent())
    component(ParentGroupComponent(Weapons.Hammer))
    component(MarketItemGroupComponent(1590999596))
  }

  val Hornet = entity(1585608388) {
    templateAccessor(ChildGraffitiMarketItemTemplate(), "garage/graffiti/child/hornet")
    component(RestrictionByUserFractionComponent())
    component(ParentGroupComponent(Hulls.Hornet))
    component(MarketItemGroupComponent(1585608388))
  }

  val Hunter = entity(1591036114) {
    templateAccessor(ChildGraffitiMarketItemTemplate(), "garage/graffiti/child/hunter")
    component(RestrictionByUserFractionComponent())
    component(ParentGroupComponent(Hulls.Hunter))
    component(MarketItemGroupComponent(1591036114))
  }

  val Isis = entity(-758092378) {
    templateAccessor(ChildGraffitiMarketItemTemplate(), "garage/graffiti/child/isis")
    component(RestrictionByUserFractionComponent())
    component(ParentGroupComponent(Weapons.Isis))
    component(MarketItemGroupComponent(-758092378))
  }

  val Mammoth = entity(1646325085) {
    templateAccessor(ChildGraffitiMarketItemTemplate(), "garage/graffiti/child/mammoth")
    component(RestrictionByUserFractionComponent())
    component(ParentGroupComponent(Hulls.Mammoth))
    component(MarketItemGroupComponent(1646325085))
  }

  val Railgun = entity(1785144668) {
    templateAccessor(ChildGraffitiMarketItemTemplate(), "garage/graffiti/child/railgun")
    component(RestrictionByUserFractionComponent())
    component(ParentGroupComponent(Weapons.Railgun))
    component(MarketItemGroupComponent(1785144668))
  }

  val Ricochet = entity(2140835849) {
    templateAccessor(ChildGraffitiMarketItemTemplate(), "garage/graffiti/child/ricochet")
    component(RestrictionByUserFractionComponent())
    component(ParentGroupComponent(Weapons.Ricochet))
    component(MarketItemGroupComponent(2140835849))
  }

  val Shaft = entity(-2017127704) {
    templateAccessor(ChildGraffitiMarketItemTemplate(), "garage/graffiti/child/shaft")
    component(RestrictionByUserFractionComponent())
    component(ParentGroupComponent(Weapons.Shaft))
    component(MarketItemGroupComponent(-2017127704))
  }

  val Smoky = entity(-2016965135) {
    templateAccessor(ChildGraffitiMarketItemTemplate(), "garage/graffiti/child/smoky")
    component(RestrictionByUserFractionComponent())
    component(ParentGroupComponent(Weapons.Smoky))
    component(MarketItemGroupComponent(-2016965135))
  }

  val Thunder = entity(-523272750) {
    templateAccessor(ChildGraffitiMarketItemTemplate(), "garage/graffiti/child/thunder")
    component(RestrictionByUserFractionComponent())
    component(ParentGroupComponent(Weapons.Thunder))
    component(MarketItemGroupComponent(-523272750))
  }

  val Titan = entity(-2016156294) {
    templateAccessor(ChildGraffitiMarketItemTemplate(), "garage/graffiti/child/titan")
    component(RestrictionByUserFractionComponent())
    component(ParentGroupComponent(Hulls.Titan))
    component(MarketItemGroupComponent(-2016156294))
  }

  val Twins = entity(-2015749383) {
    templateAccessor(ChildGraffitiMarketItemTemplate(), "garage/graffiti/child/twins")
    component(RestrictionByUserFractionComponent())
    component(ParentGroupComponent(Weapons.Twins))
    component(MarketItemGroupComponent(-2015749383))
  }

  val Viking = entity(1980662300) {
    templateAccessor(ChildGraffitiMarketItemTemplate(), "garage/graffiti/child/viking")
    component(RestrictionByUserFractionComponent())
    component(ParentGroupComponent(Hulls.Viking))
    component(MarketItemGroupComponent(1980662300))
  }

  val Vulcan = entity(1991768181) {
    templateAccessor(ChildGraffitiMarketItemTemplate(), "garage/graffiti/child/vulcan")
    component(RestrictionByUserFractionComponent())
    component(ParentGroupComponent(Weapons.Vulcan))
    component(MarketItemGroupComponent(1991768181))
  }

  val Wasp = entity(-757692295) {
    templateAccessor(ChildGraffitiMarketItemTemplate(), "garage/graffiti/child/wasp")
    component(RestrictionByUserFractionComponent())
    component(ParentGroupComponent(Hulls.Wasp))
    component(MarketItemGroupComponent(-757692295))
  }

  val _23february2017_1 = entity(-571325446) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/23february2017_1")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-571325446))
  }

  val _23february2017_2 = entity(-571325445) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/23february2017_2")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-571325445))
  }

  val _23february2018 = entity(473147977) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/23february2018")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(473147977))
  }

  val _8marchcat = entity(-1669172271) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/8marchcat")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-1669172271))
  }

  val _8marchcrystal = entity(2069414001) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/8marchcrystal")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(2069414001))
  }

  val Alien = entity(-2022929356) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/alien")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-2022929356))
  }

  val Antaeus = entity(-1628984953) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/antaeus")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-1628984953))
  }

  val Armsrace = entity(-1968456698) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/armsrace")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-1968456698))
  }

  val Atlas = entity(968765463) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/atlas")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(968765463))
  }

  val Attackoftitan = entity(891728345) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/attackoftitan")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(891728345))
  }

  val Birthday2017graffiti = entity(-1278226971) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/birthday2017graffiti")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-1278226971))
  }

  val Bulldog = entity(-107843627) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/bulldog")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-107843627))
  }

  val Bullterier = entity(315308508) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/bullterier")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(315308508))
  }

  val Caveman = entity(-24677874) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/caveman")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-24677874))
  }

  val Cosmosx = entity(678025425) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/cosmosx")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(678025425))
  }

  val Demolisher = entity(-343773791) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/demolisher")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-343773791))
  }

  val Demon = entity(971090551) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/demon")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(971090551))
  }

  val Devilsheart = entity(-194604214) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/devilsheart")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-194604214))
  }

  val Doberman = entity(519082359) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/doberman")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(519082359))
  }

  val Fetih = entity(292147378) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/fetih")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(292147378))
  }

  val Frontier = entity(-781845119) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/frontier")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-781845119))
  }

  val Ghosttrain = entity(-1779805396) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/ghosttrain")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-1779805396))
  }

  val Giant = entity(-1968456699) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/giant")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-1968456699))
  }

  val Godmode = entity(880222526) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/godmode")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(880222526))
  }

  val Goldbill = entity(1737433896) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/goldbill")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(1737433896))
  }

  val Goldbox = entity(887330442) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/goldbox")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(887330442))
  }

  val Hellhound = entity(1951474656) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/hellhound")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(1951474656))
  }

  val Heroorder = entity(113459975) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/heroorder")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(113459975))
  }

  val Hydra = entity(1289970222) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/hydra")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(1289970222))
  }

  val Iwojima = entity(-303400441) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/iwojima")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-303400441))
  }

  val Letsgo = entity(1391443781) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/letsgo")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(1391443781))
  }

  val Logo = entity(1001404575) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/logo")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(1001404575))
  }

  val Luck = entity(-93361699) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/luck")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-93361699))
  }

  val Marshalstar = entity(988897323) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/marshalstar")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(988897323))
  }

  val May2018_1 = entity(1775068808) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/may2018_1")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(1775068808))
  }

  val May2018_2 = entity(1775068809) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/may2018_2")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(1775068809))
  }

  val Monster = entity(895058022) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/monster")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(895058022))
  }

  val Motherland = entity(-2050212779) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/motherland")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-2050212779))
  }

  val Nuke = entity(1001470037) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/nuke")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(1001470037))
  }

  val Partners = entity(-1611647112) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/partners")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-1611647112))
  }

  val Peace = entity(674847565) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/peace")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(674847565))
  }

  val Pixelduck = entity(1384981436) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/pixelduck")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(1384981436))
  }

  val Pumpkin = entity(457993351) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/pumpkin")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(457993351))
  }

  val Pumpkin2017 = entity(-1786896255) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/pumpkin2017")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-1786896255))
  }

  val Season0 = entity(-247809917) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/season0")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-247809917))
  }

  val Season0top = entity(545710246) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/season0top")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(545710246))
  }

  val Season1 = entity(-247809886) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/season1")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-247809886))
  }

  val Season1top = entity(546633767) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/season1top")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(546633767))
  }

  val Season5 = entity(1690446069) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/season5")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(1690446069))
  }

  val Season5top = entity(1587411008) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/season5top")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(1587411008))
  }

  val Season6 = entity(1626810943) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/season6")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(1626810943))
  }

  val Season6top = entity(-86050122) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/season6top")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-86050122))
  }

  val Season10 = entity(-1834580363) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/seasons/season10")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-1834580363))
  }

  val Season10top = entity(-524637504) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/seasons/season10top")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-524637504))
  }

  val Season11 = entity(-1834580367) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/seasons/season11")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-1834580367))
  }

  val Season11top = entity(-524637507) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/seasons/season11top")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-524637507))
  }

  val Season12 = entity(-1834580368) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/seasons/season12")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-1834580368))
  }

  val Season12top = entity(-524637508) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/seasons/season12top")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-524637508))
  }

  val Season2 = entity(217914652) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/seasons/season2")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(217914652))
  }

  val Season2top = entity(-2095038791) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/seasons/season2top")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-2095038791))
  }

  val Season3 = entity(217914653) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/seasons/season3")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(217914653))
  }

  val Season3top = entity(-2095009000) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/seasons/season3top")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-2095009000))
  }

  val Season3_ny2018 = entity(1994390162) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/seasons/season3_ny2018")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(1994390162))
  }

  val Season3_ny2018top = entity(-1700141693) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/seasons/season3_ny2018top")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-1700141693))
  }

  val Season4 = entity(217914654) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/seasons/season4")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(217914654))
  }

  val Season4top = entity(-2094979209) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/seasons/season4top")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-2094979209))
  }

  val Season7 = entity(345912680) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/seasons/season7")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(345912680))
  }

  val Season7top = entity(-1792984208) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/seasons/season7top")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-1792984208))
  }

  val Season8 = entity(217914658) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/seasons/season8")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(217914658))
  }

  val Season8top = entity(-2094860045) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/seasons/season8top")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-2094860045))
  }

  val Season9 = entity(217914659) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/seasons/season9")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(217914659))
  }

  val Season9top = entity(-2094830254) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/seasons/season9top")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-2094830254))
  }

  val Steampunk = entity(62042919) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/steampunk")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(62042919))
  }

  val Stvalentine2017_1 = entity(-1808985494) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/stvalentine2017_1")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-1808985494))
  }

  val Stvalentine2017_2 = entity(-1808985493) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/stvalentine2017_2")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-1808985493))
  }

  val Tanki2 = entity(1086271184) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/tanki2")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(1086271184))
  }

  val Up = entity(1884609450) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/up")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(1884609450))
  }

  val Valhalla_drakkar = entity(1285677037) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/valhalla_drakkar")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(1285677037))
  }

  val Valhalla_valkyrie = entity(619790646) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/valhalla_valkyrie")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(619790646))
  }

  val Valhalla_yggdrasil = entity(-1871711547) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/valhalla_yggdrasil")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-1871711547))
  }

  val Vdnhstatue = entity(-1333610377) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/vdnhstatue")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-1333610377))
  }

  val Waroftheworlds = entity(1374508848) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/waroftheworlds")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(1374508848))
  }

  val Widow = entity(1704628950) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/widow")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(1704628950))
  }

  val Xmas1 = entity(-25726372) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/xmas1")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(-25726372))
  }

  val Xmas2 = entity(432765771) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/xmas2")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(432765771))
  }

  val Xmas3 = entity(1435022351) {
    templateAccessor(GraffitiMarketItemTemplate(), "garage/graffiti/independent/xmas3")
    component(RestrictionByUserFractionComponent())
    component(MarketItemGroupComponent(1435022351))
  }
}
