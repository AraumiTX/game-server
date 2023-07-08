package jp.assasans.araumi.tx.server.ecs.globalEntities

import jp.assasans.araumi.tx.server.ecs.components.group.MarketItemGroupComponent
import jp.assasans.araumi.tx.server.ecs.components.user.UserGroupComponent
import jp.assasans.araumi.tx.server.ecs.entities.IEntity
import jp.assasans.araumi.tx.server.ecs.entities.component
import jp.assasans.araumi.tx.server.ecs.entities.entity
import jp.assasans.araumi.tx.server.ecs.entities.templateAccessor
import jp.assasans.araumi.tx.server.ecs.entities.templates.hulls.market.TankPaintMarketItemTemplate
import jp.assasans.araumi.tx.server.ecs.entities.templates.hulls.user.TankPaintUserItemTemplate
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import kotlin.reflect.full.declaredMemberProperties

@Suppress("ObjectPropertyName", "SpellCheckingInspection")
object Paints : IGlobalEntities {
    fun getUserTemplateItems(player: IPlayerConnection) =
        Paints::class.declaredMemberProperties
            .map { (it.get(this) as IEntity).clone() }
            .onEach {
                it.templateAccessor!!.template = TankPaintUserItemTemplate()

                //todo check if user has this item
                it.addComponent(UserGroupComponent(player.user.id))
            }

    val _23feb2019 = entity(300183087) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/23feb2019")
        component(MarketItemGroupComponent(300183087))
    }

    val Antaeus1 = entity(1104561449) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/antaeus1")
        component(MarketItemGroupComponent(1104561449))
    }

    val Antaeus2018 = entity(1104561450) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/antaeus2018")
        component(MarketItemGroupComponent(1104561450))
    }

    val Antarctida = entity(683803510) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/antarctida")
        component(MarketItemGroupComponent(683803510))
    }

    val Arrowsoflove = entity(-400341658) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/arrowsoflove")
        component(MarketItemGroupComponent(-400341658))
    }

    val Autumnleaves = entity(-662236117) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/autumnleaves")
        component(MarketItemGroupComponent(-662236117))
    }

    val Bananas = entity(-574655849) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/bananas")
        component(MarketItemGroupComponent(-574655849))
    }

    val Beginning = entity(-1500327034) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/beginning")
        component(MarketItemGroupComponent(-1500327034))
    }

    val Birthday2017 = entity(776075330) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/birthday2017")
        component(MarketItemGroupComponent(776075330))
    }

    val Blackroger = entity(2008328619) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/blackroger")
        component(MarketItemGroupComponent(2008328619))
    }

    val Blue = entity(137747283) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/blue")
        component(MarketItemGroupComponent(137747283))
    }

    val Bluemagma = entity(436923060) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/bluemagma")
        component(MarketItemGroupComponent(436923060))
    }

    val Canyon = entity(214261055) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/canyon")
        component(MarketItemGroupComponent(214261055))
    }

    val Carbon = entity(214261056) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/carbon")
        component(MarketItemGroupComponent(214261056))
    }

    val Ceder = entity(-24102762) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/ceder")
        component(MarketItemGroupComponent(-24102762))
    }

    val Champion = entity(1798212322) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/champion")
        component(MarketItemGroupComponent(1798212322))
    }

    val Coal = entity(920905258) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/coal")
        component(MarketItemGroupComponent(920905258))
    }

    val Corrosion = entity(1569952799) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/corrosion")
        component(MarketItemGroupComponent(1569952799))
    }

    val Desert = entity(-718109490) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/desert")
        component(MarketItemGroupComponent(-718109490))
    }

    val Digital = entity(-683002753) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/digital")
        component(MarketItemGroupComponent(-683002753))
    }

    val Dirt = entity(137803904) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/dirt")
        component(MarketItemGroupComponent(137803904))
    }

    val Dragon = entity(-706638132) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/dragon")
        component(MarketItemGroupComponent(-706638132))
    }

    val Easternstar = entity(1717585789) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/easternstar")
        component(MarketItemGroupComponent(1717585789))
    }

    val Epicgold = entity(-892221448) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/epicgold")
        component(MarketItemGroupComponent(-892221448))
    }

    val Flame = entity(-1514026752) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/flame")
        component(MarketItemGroupComponent(-1514026752))
    }

    val Flora = entity(-21112705) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/flora")
        component(MarketItemGroupComponent(-21112705))
    }

    val Football = entity(761115110) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/football")
        component(MarketItemGroupComponent(761115110))
    }

    val Forester = entity(833674243) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/forester")
        component(MarketItemGroupComponent(833674243))
    }

    val Freedom = entity(1347685821) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/freedom")
        component(MarketItemGroupComponent(1347685821))
    }

    val Frontier1 = entity(-1396691349) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/frontier1")
        component(MarketItemGroupComponent(-1396691349))
    }

    val Frontier2018 = entity(-1396691350) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/frontier2018")
        component(MarketItemGroupComponent(-1396691350))
    }

    val Galaxy = entity(-636128311) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/galaxy")
        component(MarketItemGroupComponent(-636128311))
    }

    val Glacier = entity(526265313) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/glacier")
        component(MarketItemGroupComponent(526265313))
    }

    val Glina = entity(-20195074) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/glina")
        component(MarketItemGroupComponent(-20195074))
    }

    val Gold = entity(921024755) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/gold")
        component(MarketItemGroupComponent(921024755))
    }

    val Green = entity(-20020438) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/green")
        component(MarketItemGroupComponent(-20020438))
    }

    val Greenskulls = entity(97943767) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/greenskulls")
        component(MarketItemGroupComponent(97943767))
    }

    val Halloween = entity(721518013) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/halloween")
        component(MarketItemGroupComponent(721518013))
    }

    val Halloween2017 = entity(1218811098) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/halloween2017")
        component(MarketItemGroupComponent(1218811098))
    }

    val Hero = entity(137919219) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/hero")
        component(MarketItemGroupComponent(137919219))
    }

    val Honeycomb = entity(1023813172) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/honeycomb")
        component(MarketItemGroupComponent(1023813172))
    }

    val Hvoya = entity(-18967536) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/hvoya")
        component(MarketItemGroupComponent(-18967536))
    }

    val Hydra = entity(-887676103) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/hydra")
        component(MarketItemGroupComponent(-887676103))
    }

    val Inferno = entity(-398350090) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/inferno")
        component(MarketItemGroupComponent(-398350090))
    }

    val League_bronze = entity(1185540727) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/league_bronze")
        component(MarketItemGroupComponent(1185540727))
    }

    val League_gold = entity(-1245546371) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/league_gold")
        component(MarketItemGroupComponent(-1245546371))
    }

    val League_master = entity(-317558887) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/league_master")
        component(MarketItemGroupComponent(-317558887))
    }

    val League_silver = entity(1663842282) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/league_silver")
        component(MarketItemGroupComponent(1663842282))
    }

    val Marine = entity(-464167301) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/marine")
        component(MarketItemGroupComponent(-464167301))
    }

    val Mary = entity(138064340) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/mary")
        component(MarketItemGroupComponent(138064340))
    }

    val Matteblack = entity(-646190818) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/matteblack")
        component(MarketItemGroupComponent(-646190818))
    }

    val Matteblue = entity(-436467641) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/matteblue")
        component(MarketItemGroupComponent(-436467641))
    }

    val Mattegray = entity(-431689890) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/mattegray")
        component(MarketItemGroupComponent(-431689890))
    }

    val Mattegreen = entity(-497382758) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/mattegreen")
        component(MarketItemGroupComponent(-497382758))
    }

    val Mattenavi = entity(-425712005) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/mattenavi")
        component(MarketItemGroupComponent(-425712005))
    }

    val Matteorange = entity(267667571) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/matteorange")
        component(MarketItemGroupComponent(267667571))
    }

    val Mattered = entity(-1260536244) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/mattered")
        component(MarketItemGroupComponent(-1260536244))
    }

    val Matterose = entity(-421603854) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/matterose")
        component(MarketItemGroupComponent(-421603854))
    }

    val Matteviolet = entity(1940431938) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/matteviolet")
        component(MarketItemGroupComponent(1940431938))
    }

    val Mattewhite = entity(-48418252) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/mattewhite")
        component(MarketItemGroupComponent(-48418252))
    }

    val Matteyellow = entity(190698221) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/matteyellow")
        component(MarketItemGroupComponent(190698221))
    }

    val May2018_1 = entity(2070833571) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/may2018_1")
        component(MarketItemGroupComponent(2070833571))
    }

    val May2018_2 = entity(2070833572) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/may2018_2")
        component(MarketItemGroupComponent(2070833572))
    }

    val Metel = entity(-14852182) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/metel")
        component(MarketItemGroupComponent(-14852182))
    }

    val Military = entity(-1660396512) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/military")
        component(MarketItemGroupComponent(-1660396512))
    }

    val Mosaic = entity(-451216061) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/mosaic")
        component(MarketItemGroupComponent(-451216061))
    }

    val Moscow = entity(-1878474135) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/moscow")
        component(MarketItemGroupComponent(-1878474135))
    }

    val Nefrit = entity(532533505) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/nefrit")
        component(MarketItemGroupComponent(532533505))
    }

    val Newyearglow = entity(-1760088841) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/newyearglow")
        component(MarketItemGroupComponent(-1760088841))
    }

    val Newyearice = entity(-888059423) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/newyearice")
        component(MarketItemGroupComponent(-888059423))
    }

    val Noise = entity(-1506541337) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/noise")
        component(MarketItemGroupComponent(-1506541337))
    }

    val North = entity(-1506532654) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/north")
        component(MarketItemGroupComponent(-1506532654))
    }

    val Orange = entity(-391711001) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/orange")
        component(MarketItemGroupComponent(-391711001))
    }

    val Orion = entity(-12628116) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/orion")
        component(MarketItemGroupComponent(-12628116))
    }

    val Partizan = entity(1555319306) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/partizan")
        component(MarketItemGroupComponent(1555319306))
    }

    val Patina = entity(-1079898253) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/patina")
        component(MarketItemGroupComponent(-1079898253))
    }

    val Pink = entity(921287177) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/pink")
        component(MarketItemGroupComponent(921287177))
    }

    val Polar = entity(-1504691957) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/polar")
        component(MarketItemGroupComponent(-1504691957))
    }

    val Priboy = entity(-362854786) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/priboy")
        component(MarketItemGroupComponent(-362854786))
    }

    val Prodigy = entity(1641998027) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/prodigy")
        component(MarketItemGroupComponent(1641998027))
    }

    val Radiation = entity(1223441167) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/radiation")
        component(MarketItemGroupComponent(1223441167))
    }

    val Red = entity(558647928) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/red")
        component(MarketItemGroupComponent(558647928))
    }

    val Redamber = entity(1784687185) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/redamber")
        component(MarketItemGroupComponent(1784687185))
    }

    val Rivets = entity(925876519) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/rivets")
        component(MarketItemGroupComponent(925876519))
    }

    val Rocks = entity(-9952811) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/rocks")
        component(MarketItemGroupComponent(-9952811))
    }

    val Rust = entity(276536681) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/rust")
        component(MarketItemGroupComponent(276536681))
    }

    val Sandstone = entity(138818312) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/sandstone")
        component(MarketItemGroupComponent(138818312))
    }

    val Savanna = entity(-470773521) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/savanna")
        component(MarketItemGroupComponent(-470773521))
    }

    val Smoke = entity(-9077354) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/smoke")
        component(MarketItemGroupComponent(-9077354))
    }

    val Spectre = entity(-56970637) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/spectre")
        component(MarketItemGroupComponent(-56970637))
    }

    val Spiderweb = entity(355636982) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/spiderweb")
        component(MarketItemGroupComponent(355636982))
    }

    val Sport = entity(-1207082244) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/sport")
        component(MarketItemGroupComponent(-1207082244))
    }

    val Starrysky = entity(-1732490966) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/starrysky")
        component(MarketItemGroupComponent(-1732490966))
    }

    val Steamulatorf = entity(1880146981) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/steamulatorf")
        component(MarketItemGroupComponent(1880146981))
    }

    val Steamulatorsf = entity(-1844971488) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/steamulatorsf")
        component(MarketItemGroupComponent(-1844971488))
    }

    val Steel = entity(-1501779048) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/steel")
        component(MarketItemGroupComponent(-1501779048))
    }

    val Stone = entity(-1756632159) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/stone")
        component(MarketItemGroupComponent(-1756632159))
    }

    val Storm = entity(-8868592) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/storm")
        component(MarketItemGroupComponent(-8868592))
    }

    val Stvalentine2017 = entity(986557478) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/stvalentine2017")
        component(MarketItemGroupComponent(986557478))
    }

    val Summer = entity(-274067352) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/summer")
        component(MarketItemGroupComponent(-274067352))
    }

    val Swamp = entity(-8792825) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/swamp")
        component(MarketItemGroupComponent(-8792825))
    }

    val Taiga = entity(-8517219) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/taiga")
        component(MarketItemGroupComponent(-8517219))
    }

    val Tar = entity(-1209537658) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/tar")
        component(MarketItemGroupComponent(-1209537658))
    }

    val Tina = entity(138280417) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/tina")
        component(MarketItemGroupComponent(138280417))
    }

    val Trianglecamo = entity(-1902859834) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/trianglecamo")
        component(MarketItemGroupComponent(-1902859834))
    }

    val Trollface = entity(1546602523) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/trollface")
        component(MarketItemGroupComponent(1546602523))
    }

    val Tundra = entity(-245416673) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/tundra")
        component(MarketItemGroupComponent(-245416673))
    }

    val Universe = entity(942805628) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/universe")
        component(MarketItemGroupComponent(942805628))
    }

    val Urban = entity(-7094151) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/urban")
        component(MarketItemGroupComponent(-7094151))
    }

    val Vostok1 = entity(-2023428617) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/vostok1")
        component(MarketItemGroupComponent(-2023428617))
    }

    val Walker = entity(-50932577) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/walker")
        component(MarketItemGroupComponent(-50932577))
    }
}