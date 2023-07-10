package jp.assasans.araumi.tx.server.ecs.globalEntities

import kotlin.reflect.full.declaredMemberProperties
import jp.assasans.araumi.tx.server.ecs.components.group.MarketItemGroupComponent
import jp.assasans.araumi.tx.server.ecs.components.user.UserGroupComponent
import jp.assasans.araumi.tx.server.ecs.entities.IEntity
import jp.assasans.araumi.tx.server.ecs.entities.component
import jp.assasans.araumi.tx.server.ecs.entities.entity
import jp.assasans.araumi.tx.server.ecs.entities.templateAccessor
import jp.assasans.araumi.tx.server.ecs.entities.templates.avatars.market.AvatarMarketItemTemplate
import jp.assasans.araumi.tx.server.ecs.entities.templates.avatars.user.AvatarUserItemTemplate
import jp.assasans.araumi.tx.server.network.IPlayerConnection

@Suppress("ObjectPropertyName", "SpellCheckingInspection")
object Avatars : IUserGlobalEntities {
  override fun getUserTemplateItems(player: IPlayerConnection) =
    Avatars::class.declaredMemberProperties
      .map { (it.get(this) as IEntity).clone() }
      .onEach {
        it.templateAccessor!!.template = AvatarUserItemTemplate()

        // todo check if user has this item
        it.addComponent(UserGroupComponent(player.user.id))
      }

  val AlgheriaFlag = entity(-910231604) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/algheria_flag")
    component(MarketItemGroupComponent(-910231604))
  }

  val Alpha = entity(934969104) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/alpha")
    component(MarketItemGroupComponent(934969104))
  }

  val Antheusfighter = entity(6200) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/antheusfighter")
    component(MarketItemGroupComponent(6200))
  }

  val ArgentinaFlag = entity(-1202231726) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/argentina_flag")
    component(MarketItemGroupComponent(-1202231726))
  }

  val ArmeniaFlag = entity(6201) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/armenia_flag")
    component(MarketItemGroupComponent(6201))
  }

  val AustraliaFlag = entity(-1731159719) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/australia_flag")
    component(MarketItemGroupComponent(-1731159719))
  }

  val AzerbaijanFlag = entity(1174801258) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/azerbaijan_flag")
    component(MarketItemGroupComponent(1174801258))
  }

  val BelorussiaFlag = entity(6202) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/belorussia_flag")
    component(MarketItemGroupComponent(6202))
  }

  val Blackwidow = entity(1286714921) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/blackwidow")
    component(MarketItemGroupComponent(1286714921))
  }

  val Bogatyr = entity(6203) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/bogatyr")
    component(MarketItemGroupComponent(6203))
  }

  val BoyValday = entity(6204) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/boy_valday")
    component(MarketItemGroupComponent(6204))
  }

  val BrazilFlag = entity(6205) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/brazil_flag")
    component(MarketItemGroupComponent(6205))
  }

  val CanadaFlag = entity(2123817583) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/canada_flag")
    component(MarketItemGroupComponent(2123817583))
  }

  val ChinaFlag = entity(1651733218) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/china_flag")
    component(MarketItemGroupComponent(1651733218))
  }

  val Crab = entity(-1632342818) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/crab")
    component(MarketItemGroupComponent(-1632342818))
  }

  val Cyborg = entity(6206) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/cyborg")
    component(MarketItemGroupComponent(6206))
  }

  val CzechFlag = entity(-171184634) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/czech_flag")
    component(MarketItemGroupComponent(-171184634))
  }

  val DarinaLiekhtonien = entity(-1473761734) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/darina_liekhtonien")
    component(MarketItemGroupComponent(-1473761734))
  }

  val DeanCunningham = entity(1479495495) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/dean_cunningham")
    component(MarketItemGroupComponent(1479495495))
  }

  val Dygest = entity(-983105950) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/dygest")
    component(MarketItemGroupComponent(-983105950))
  }

  val Eagle = entity(938326966) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/eagle")
    component(MarketItemGroupComponent(938326966))
  }

  val EgyptFlag = entity(-1089651106) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/egypt_flag")
    component(MarketItemGroupComponent(-1089651106))
  }

  val Elite = entity(6207) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/elite")
    component(MarketItemGroupComponent(6207))
  }

  val EmmaBonney = entity(-2119697962) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/emma_bonney")
    component(MarketItemGroupComponent(-2119697962))
  }

  val EstoniaFlag = entity(1781929660) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/estonia_flag")
    component(MarketItemGroupComponent(1781929660))
  }

  val EvgenyRomanov = entity(-1130044595) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/evgeny_romanov")
    component(MarketItemGroupComponent(-1130044595))
  }

  val FinlandFlag = entity(-241092701) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/finland_flag")
    component(MarketItemGroupComponent(-241092701))
  }

  val FranceFlag = entity(117983554) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/france_flag")
    component(MarketItemGroupComponent(117983554))
  }

  val Frontierfighter = entity(6208) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/frontierfighter")
    component(MarketItemGroupComponent(6208))
  }

  val Gambler = entity(1569342716) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/gambler")
    component(MarketItemGroupComponent(1569342716))
  }

  val GarciaLopez = entity(1953932916) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/garcia_lopez")
    component(MarketItemGroupComponent(1953932916))
  }

  val GeorgiaFlag = entity(6209) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/georgia_flag")
    component(MarketItemGroupComponent(6209))
  }

  val GermanyFlag = entity(6210) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/germany_flag")
    component(MarketItemGroupComponent(6210))
  }

  val Ghostrider = entity(6211) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/ghostrider")
    component(MarketItemGroupComponent(6211))
  }

  val GirlValday = entity(6212) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/girl_valday")
    component(MarketItemGroupComponent(6212))
  }

  val GreatbritainFlag = entity(6213) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/greatbritain_flag")
    component(MarketItemGroupComponent(6213))
  }

  val GreeceFlag = entity(1175725104) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/greece_flag")
    component(MarketItemGroupComponent(1175725104))
  }

  val Heart = entity(941211128) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/heart")
    component(MarketItemGroupComponent(941211128))
  }

  val Hellhound = entity(869046809) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/hellhound")
    component(MarketItemGroupComponent(869046809))
  }

  val HungaryFlag = entity(232090231) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/hungary_flag")
    component(MarketItemGroupComponent(232090231))
  }

  val Hydra = entity(941809812) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/hydra")
    component(MarketItemGroupComponent(941809812))
  }

  val IndiaFlag = entity(-2048808190) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/india_flag")
    component(MarketItemGroupComponent(-2048808190))
  }

  val IrmaMassacre = entity(855079933) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/irma_massacre")
    component(MarketItemGroupComponent(855079933))
  }

  val IsraelFlag = entity(-1042657987) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/israel_flag")
    component(MarketItemGroupComponent(-1042657987))
  }

  val ItalyFlag = entity(-1887453418) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/italy_flag")
    component(MarketItemGroupComponent(-1887453418))
  }

  val Jedi = entity(6214) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/jedi")
    component(MarketItemGroupComponent(6214))
  }

  val KazakhstanFlag = entity(6215) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/kazakhstan_flag")
    component(MarketItemGroupComponent(6215))
  }

  val LatviaFlag = entity(-1036805170) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/latvia_flag")
    component(MarketItemGroupComponent(-1036805170))
  }

  val Legends = entity(1820960568) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/legends")
    component(MarketItemGroupComponent(1820960568))
  }

  val LithuaniaFlag = entity(-657725808) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/lithuania_flag")
    component(MarketItemGroupComponent(-657725808))
  }

  val MagnusGrim = entity(706204327) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/magnus_grim")
    component(MarketItemGroupComponent(706204327))
  }

  val Mammoth = entity(6216) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/mammoth")
    component(MarketItemGroupComponent(6216))
  }

  val MaryNewell = entity(1807734043) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/mary_newell")
    component(MarketItemGroupComponent(1807734043))
  }

  val MaureenLawrie = entity(764921404) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/maureen_lawrie")
    component(MarketItemGroupComponent(764921404))
  }

  val MexicoFlag = entity(224328936) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/mexico_flag")
    component(MarketItemGroupComponent(224328936))
  }

  val MichelleReisner = entity(-2083128946) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/michelle_reisner")
    component(MarketItemGroupComponent(-2083128946))
  }

  val MoldaviaFlag = entity(6217) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/moldavia_flag")
    component(MarketItemGroupComponent(6217))
  }

  val MoroccoFlag = entity(-814801911) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/morocco_flag")
    component(MarketItemGroupComponent(-814801911))
  }

  val NetherlandsFlag = entity(1927964361) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/netherlands_flag")
    component(MarketItemGroupComponent(1927964361))
  }

  val Order = entity(948065536) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/order")
    component(MarketItemGroupComponent(948065536))
  }

  val OskarKhrom = entity(-880569858) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/oskar_khrom")
    component(MarketItemGroupComponent(-880569858))
  }

  val PakistanFlag = entity(287575104) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/pakistan_flag")
    component(MarketItemGroupComponent(287575104))
  }

  val PirateGirl = entity(1455996148) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/pirate_girl")
    component(MarketItemGroupComponent(1455996148))
  }

  val PolandFlag = entity(1472995923) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/poland_flag")
    component(MarketItemGroupComponent(1472995923))
  }

  val Professor = entity(-1330873567) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/professor")
    component(MarketItemGroupComponent(-1330873567))
  }

  val Raccoon = entity(6218) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/raccoon")
    component(MarketItemGroupComponent(6218))
  }

  val RussiaFlag = entity(6219) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/russia_flag")
    component(MarketItemGroupComponent(6219))
  }

  val SaudiArabia = entity(1602513792) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/saudi_arabia_flag")
    component(MarketItemGroupComponent(1602513792))
  }

  val Savage = entity(6220) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/savage")
    component(MarketItemGroupComponent(6220))
  }

  val Skeletoninspace = entity(6221) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/skeletoninspace")
    component(MarketItemGroupComponent(6221))
  }

  val SlovakiaFlag = entity(1776630907) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/slovakia_flag")
    component(MarketItemGroupComponent(1776630907))
  }

  val SloveniaFlag = entity(-224755940) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/slovenia_flag")
    component(MarketItemGroupComponent(-224755940))
  }

  val SpainFlag = entity(399797680) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/spain_flag")
    component(MarketItemGroupComponent(399797680))
  }

  val SpyGirl = entity(1612159053) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/spy_girl")
    component(MarketItemGroupComponent(1612159053))
  }

  val Stormtrooper = entity(6222) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/stormtrooper")
    component(MarketItemGroupComponent(6222))
  }

  val Swatsoldier = entity(6223) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/swatsoldier")
    component(MarketItemGroupComponent(6223))
  }

  val SwedenFlag = entity(394437137) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/sweden_flag")
    component(MarketItemGroupComponent(394437137))
  }

  val Tankist = entity(6224) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/tankist")
    component(MarketItemGroupComponent(6224))
  }

  val Tankix = entity(6225) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/tankix")
    component(MarketItemGroupComponent(6225))
  }

  val TeresaAmsel = entity(1657247215) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/teresa_amsel")
    component(MarketItemGroupComponent(1657247215))
  }

  val ThailandFlag = entity(187162326) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/thailand_flag")
    component(MarketItemGroupComponent(187162326))
  }

  val Troll = entity(6226) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/troll")
    component(MarketItemGroupComponent(6226))
  }

  val TurkeyFlag = entity(893099663) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/turkey_flag")
    component(MarketItemGroupComponent(893099663))
  }

  val UkraineFlag = entity(6227) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/ukraine_flag")
    component(MarketItemGroupComponent(6227))
  }

  val UsaFlag = entity(6228) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/usa_flag")
    component(MarketItemGroupComponent(6228))
  }

  val VeraKlein = entity(-1147853194) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/vera_klein")
    component(MarketItemGroupComponent(-1147853194))
  }

  val Viking = entity(6229) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/viking")
    component(MarketItemGroupComponent(6229))
  }

  val VladimirRepin = entity(-480997961) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/vladimir_repin")
    component(MarketItemGroupComponent(-480997961))
  }

  val Wasp = entity(6230) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/wasp")
    component(MarketItemGroupComponent(6230))
  }

  val YamamotoTsunetomo = entity(605003762) {
    templateAccessor(AvatarMarketItemTemplate(), "garage/avatar/yamamoto_tsunetomo")
    component(MarketItemGroupComponent(605003762))
  }
}
