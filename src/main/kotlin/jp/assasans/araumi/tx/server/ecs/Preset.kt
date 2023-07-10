package jp.assasans.araumi.tx.server.ecs

import jp.assasans.araumi.tx.server.ecs.components.item.preset.PresetEquipmentComponent
import jp.assasans.araumi.tx.server.ecs.entities.IEntity
import jp.assasans.araumi.tx.server.ecs.globalEntities.*
import jp.assasans.araumi.tx.server.extensions.transform
import jp.assasans.araumi.tx.server.network.IPlayerConnection

data class Preset(
  private val player: IPlayerConnection,
  val preset: IEntity
) {
  var component: PresetEquipmentComponent

  val weapon: IEntity = Weapons.Smoky
  val coating: IEntity
  val weaponItem: IEntity
  val weaponSkins: Map<IEntity, IEntity>

  val hull: IEntity = Hulls.Hunter
  val paint: IEntity
  val hullItem: IEntity
  val hullSkins: Map<IEntity, IEntity>

  val graffiti: IEntity
  val shells: Map<IEntity, IEntity>
  val modules: Map<IEntity, IEntity?>

  init {
    val weaponsList = player.player.userTemplateItems[Weapons::class] ?: Weapons.getUserTemplateItems(player)
    val coatingsList = player.player.userTemplateItems[Coatings::class] ?: Coatings.getUserTemplateItems(player)
    val weaponSkinsList = player.player.userTemplateItems[WeaponSkins::class] ?: WeaponSkins.getUserTemplateItems(player)
    val shellsList = player.player.userTemplateItems[Shells::class] ?: Shells.getUserTemplateItems(player)
    val weaponDefaultSkins = Weapons.getDefaultSkins()
    val weaponDefaultShells = Weapons.getDefaultShells()

    val hullsList = player.player.userTemplateItems[Hulls::class] ?: Hulls.getUserTemplateItems(player)
    val paintsList = player.player.userTemplateItems[Paints::class] ?: Paints.getUserTemplateItems(player)
    val hullSkinsList = player.player.userTemplateItems[HullSkins::class] ?: HullSkins.getUserTemplateItems(player)
    val hullDefaultSkins = Hulls.getDefaultSkins()

    val graffitiList = player.player.userTemplateItems[Graffiti::class] ?: Graffiti.getUserTemplateItems(player)

    //todo val moduleSlotsList = player.player.userTemplateItems[ModuleSlots::class] ?: ModuleSlots.getUserTemplateItems(player)

    weaponItem = weaponsList.single { it.id == Weapons.Smoky.id }
    hullItem = hullsList.single { it.id == Hulls.Hunter.id }

    coating = coatingsList.single { it.id == Coatings.None.id }
    paint = paintsList.single { it.id == Paints.Green.id }
    graffiti = graffitiList.single { it.id == Graffiti.Birthday2017graffiti.id }

    weaponSkins = weaponDefaultSkins.transform { weaponSkin ->
      val weapon = weaponsList.single { weapon -> weaponSkin.key.id == weapon.id }
      val skin = weaponSkinsList.single { skin -> weaponSkin.value.id == skin.id }

      Pair(weapon, skin)
    }

    hullSkins = hullDefaultSkins.transform { hullSkin ->
      val hull = hullsList.single { hull -> hullSkin.key.id == hull.id }
      val skin = hullSkinsList.single { skin -> hullSkin.value.id == skin.id }

      Pair(hull, skin)
    }

    shells = weaponDefaultShells.transform { weaponShell ->
      val weapon = weaponsList.single { weapon -> weaponShell.key.id == weapon.id }
      val shell = shellsList.single { shell -> weaponShell.value.id == shell.id }

      Pair(weapon, shell)
    }

    modules = mapOf(
      //todo Modules
    )

    component = PresetEquipmentComponent(weapon.id, hull.id)

    fun getItem(item: IEntity, globalEntities: IUserGlobalEntities) =
      globalEntities.getMarketTemplateItems().single { it.templateAccessor?.configPath == item.templateAccessor?.configPath }
  }
}
