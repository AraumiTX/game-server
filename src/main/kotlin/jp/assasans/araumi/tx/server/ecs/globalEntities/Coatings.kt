package jp.assasans.araumi.tx.server.ecs.globalEntities

import kotlin.reflect.full.declaredMemberProperties
import jp.assasans.araumi.tx.server.ecs.components.group.MarketItemGroupComponent
import jp.assasans.araumi.tx.server.ecs.components.user.UserGroupComponent
import jp.assasans.araumi.tx.server.ecs.entities.IEntity
import jp.assasans.araumi.tx.server.ecs.entities.component
import jp.assasans.araumi.tx.server.ecs.entities.entity
import jp.assasans.araumi.tx.server.ecs.entities.templateAccessor
import jp.assasans.araumi.tx.server.ecs.entities.templates.weapons.market.WeaponPaintMarketItemTemplate
import jp.assasans.araumi.tx.server.ecs.entities.templates.weapons.user.WeaponPaintUserItemTemplate
import jp.assasans.araumi.tx.server.network.IPlayerConnection

@Suppress("ObjectPropertyName", "SpellCheckingInspection")
object Coatings : IUserGlobalEntities {
  override fun getUserTemplateItems(player: IPlayerConnection) =
    Coatings::class.declaredMemberProperties
      .map { (it.get(this) as IEntity).clone() }
      .onEach {
        it.templateAccessor!!.template = WeaponPaintUserItemTemplate()

        // todo check if user has this item
        it.addComponent(UserGroupComponent(player.user.id))
      }

  val Antaeus1 = entity(-891349912) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/antaeus1")
    component(MarketItemGroupComponent(-891349912))
  }

  val Antaeus2018 = entity(1577640270) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/antaeus2018")
    component(MarketItemGroupComponent(1577640270))
  }

  val Blue = entity(-172609771) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/blue")
    component(MarketItemGroupComponent(-172609771))
  }

  val Carbon = entity(1644116328) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/carbon")
    component(MarketItemGroupComponent(1644116328))
  }

  val Ceder = entity(-1055236844) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/ceder")
    component(MarketItemGroupComponent(-1055236844))
  }

  val Champion = entity(888876452) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/champion")
    component(MarketItemGroupComponent(888876452))
  }

  val Coal = entity(-172577710) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/coal")
    component(MarketItemGroupComponent(-172577710))
  }

  val Corrosion = entity(-849655395) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/corrosion")
    component(MarketItemGroupComponent(-849655395))
  }

  val Desert = entity(1676472336) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/desert")
    component(MarketItemGroupComponent(1676472336))
  }

  val Digital = entity(534589821) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/digital")
    component(MarketItemGroupComponent(534589821))
  }

  val Dirt = entity(-172553150) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/dirt")
    component(MarketItemGroupComponent(-172553150))
  }

  val Dragon = entity(1687943694) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/dragon")
    component(MarketItemGroupComponent(1687943694))
  }

  val Flame = entity(-1052260392) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/flame")
    component(MarketItemGroupComponent(-1052260392))
  }

  val Flora = entity(-1052246787) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/flora")
    component(MarketItemGroupComponent(-1052246787))
  }

  val Forester = entity(-75661627) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/forester")
    component(MarketItemGroupComponent(-75661627))
  }

  val Frontier1 = entity(610004612) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/frontier1")
    component(MarketItemGroupComponent(610004612))
  }

  val Frontier2018 = entity(640844210) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/frontier2018")
    component(MarketItemGroupComponent(640844210))
  }

  val Galaxy = entity(-64859568) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/galaxy")
    component(MarketItemGroupComponent(-64859568))
  }

  val Glacier = entity(-1705840017) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/glacier")
    component(MarketItemGroupComponent(-1705840017))
  }

  val Glina = entity(-1051329156) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/glina")
    component(MarketItemGroupComponent(-1051329156))
  }

  val Gold = entity(-172458213) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/gold")
    component(MarketItemGroupComponent(-172458213))
  }

  val Green = entity(-1051154520) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/green")
    component(MarketItemGroupComponent(-1051154520))
  }

  val Greenskulls = entity(1953107513) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/greenskulls")
    component(MarketItemGroupComponent(1953107513))
  }

  val Halloween = entity(-1128248718) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/halloween")
    component(MarketItemGroupComponent(-1128248718))
  }

  val Honeycomb = entity(-784118404) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/honeycomb")
    component(MarketItemGroupComponent(-784118404))
  }

  val Hvoya = entity(-1050101618) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/hvoya")
    component(MarketItemGroupComponent(-1050101618))
  }

  val Inferno = entity(819242484) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/inferno")
    component(MarketItemGroupComponent(819242484))
  }

  val Izumrud = entity(372065215) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/izumrud")
    component(MarketItemGroupComponent(372065215))
  }

  val Lightblue = entity(1167717168) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/lightblue")
    component(MarketItemGroupComponent(1167717168))
  }

  val Marine = entity(1930414525) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/marine")
    component(MarketItemGroupComponent(1930414525))
  }

  val Mary = entity(-172292714) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/mary")
    component(MarketItemGroupComponent(-172292714))
  }

  val Matteblack = entity(1958622537) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/matteblack")
    component(MarketItemGroupComponent(1958622537))
  }

  val Matteblue = entity(1448655312) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/matteblue")
    component(MarketItemGroupComponent(1448655312))
  }

  val Mattegray = entity(1448809433) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/mattegray")
    component(MarketItemGroupComponent(1448809433))
  }

  val Mattegreen = entity(1963422797) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/mattegreen")
    component(MarketItemGroupComponent(1963422797))
  }

  val Mattenavi = entity(1449002268) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/mattenavi")
    component(MarketItemGroupComponent(1449002268))
  }

  val Matteorange = entity(965487140) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/matteorange")
    component(MarketItemGroupComponent(965487140))
  }

  val Mattered = entity(-230348709) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/mattered")
    component(MarketItemGroupComponent(-230348709))
  }

  val Matterose = entity(1449134789) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/matterose")
    component(MarketItemGroupComponent(1449134789))
  }

  val Matteviolet = entity(1157994613) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/matteviolet")
    component(MarketItemGroupComponent(1157994613))
  }

  val Mattewhite = entity(1977905523) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/mattewhite")
    component(MarketItemGroupComponent(1977905523))
  }

  val Matteyellow = entity(1240098922) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/matteyellow")
    component(MarketItemGroupComponent(1240098922))
  }

  val May2018_1 = entity(-217437764) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/may2018_1")
    component(MarketItemGroupComponent(-217437764))
  }

  val May2018_2 = entity(-217437763) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/may2018_2")
    component(MarketItemGroupComponent(-217437763))
  }

  val Metel = entity(-1045986264) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/metel")
    component(MarketItemGroupComponent(-1045986264))
  }

  val Nefrit = entity(1962388777) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/nefrit")
    component(MarketItemGroupComponent(1962388777))
  }

  val Newyearglow = entity(1273539023) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/newyearglow")
    component(MarketItemGroupComponent(1273539023))
  }

  val Newyearice = entity(-97463799) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/newyearice")
    component(MarketItemGroupComponent(-97463799))
  }

  val Noise = entity(-1044774977) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/noise")
    component(MarketItemGroupComponent(-1044774977))
  }

  val None = entity(-172249613) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/none")
    component(MarketItemGroupComponent(-172249613))
  }

  val North = entity(-1044766294) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/north")
    component(MarketItemGroupComponent(-1044766294))
  }

  val Orange = entity(2002870825) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/orange")
    component(MarketItemGroupComponent(2002870825))
  }

  val Partizan = entity(645983436) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/partizan")
    component(MarketItemGroupComponent(645983436))
  }

  val Patina = entity(2016361556) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/patina")
    component(MarketItemGroupComponent(2016361556))
  }

  val Pink = entity(-172195791) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/pink")
    component(MarketItemGroupComponent(-172195791))
  }

  val Polar = entity(-1042925597) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/polar")
    component(MarketItemGroupComponent(-1042925597))
  }

  val Priboy = entity(2031727040) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/priboy")
    component(MarketItemGroupComponent(2031727040))
  }

  val Prodigy = entity(-1435376695) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/prodigy")
    component(MarketItemGroupComponent(-1435376695))
  }

  val Radiation = entity(-500584127) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/radiation")
    component(MarketItemGroupComponent(-500584127))
  }

  val Red = entity(410089078) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/red")
    component(MarketItemGroupComponent(410089078))
  }

  val Rivets = entity(2081063968) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/rivets")
    component(MarketItemGroupComponent(2081063968))
  }

  val Rocks = entity(-1041086893) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/rocks")
    component(MarketItemGroupComponent(-1041086893))
  }

  val Rust = entity(-172124513) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/rust")
    component(MarketItemGroupComponent(-172124513))
  }

  val Sandstone = entity(2014177414) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/sandstone")
    component(MarketItemGroupComponent(2014177414))
  }

  val Savanna = entity(746819053) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/savanna")
    component(MarketItemGroupComponent(746819053))
  }

  val Smoke = entity(-1040211436) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/smoke")
    component(MarketItemGroupComponent(-1040211436))
  }

  val Sport = entity(-1040121831) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/sport")
    component(MarketItemGroupComponent(-1040121831))
  }

  val Starrysky = entity(-1779740531) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/starrysky")
    component(MarketItemGroupComponent(-1779740531))
  }

  val Steamulatorf = entity(1408168452) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/steamulatorf")
    component(MarketItemGroupComponent(1408168452))
  }

  val Steamulatorsf = entity(703549557) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/steamulatorsf")
    component(MarketItemGroupComponent(703549557))
  }

  val Steel = entity(-1040012688) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/steel")
    component(MarketItemGroupComponent(-1040012688))
  }

  val Stone = entity(-1040002806) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/stone")
    component(MarketItemGroupComponent(-1040002806))
  }

  val Storm = entity(-1040002674) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/storm")
    component(MarketItemGroupComponent(-1040002674))
  }

  val Stvalentine2017 = entity(-26936066) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/stvalentine2017")
    component(MarketItemGroupComponent(-26936066))
  }

  val Swamp = entity(-1039926907) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/swamp")
    component(MarketItemGroupComponent(-1039926907))
  }

  val Taiga = entity(-1039651301) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/taiga")
    component(MarketItemGroupComponent(-1039651301))
  }

  val Tar = entity(410090890) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/tar")
    component(MarketItemGroupComponent(410090890))
  }

  val Tina = entity(-172076637) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/tina")
    component(MarketItemGroupComponent(-172076637))
  }

  val Trianglecamo = entity(-2097840184) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/trianglecamo")
    component(MarketItemGroupComponent(-2097840184))
  }

  val Tundra = entity(-2145802143) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/tundra")
    component(MarketItemGroupComponent(-2145802143))
  }

  val Universe = entity(176253763) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/universe")
    component(MarketItemGroupComponent(176253763))
  }

  val Urban = entity(-1038228233) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/urban")
    component(MarketItemGroupComponent(-1038228233))
  }

  val Vostok1 = entity(-487032800) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/vostok1")
    component(MarketItemGroupComponent(-487032800))
  }

  val Walker = entity(-2078438351) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/walker")
    component(MarketItemGroupComponent(-2078438351))
  }

  val Yellow = entity(454169524) {
    templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/yellow")
    component(MarketItemGroupComponent(454169524))
  }
}
