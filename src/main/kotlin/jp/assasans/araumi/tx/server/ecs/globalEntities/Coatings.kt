package jp.assasans.araumi.tx.server.ecs.globalEntities

import jp.assasans.araumi.tx.server.ecs.components.group.MarketItemGroupComponent
import jp.assasans.araumi.tx.server.ecs.components.user.UserGroupComponent
import jp.assasans.araumi.tx.server.ecs.entities.IEntity
import jp.assasans.araumi.tx.server.ecs.entities.component
import jp.assasans.araumi.tx.server.ecs.entities.entity
import jp.assasans.araumi.tx.server.ecs.entities.templateAccessor
import jp.assasans.araumi.tx.server.ecs.entities.templates.weapons.market.*
import jp.assasans.araumi.tx.server.ecs.entities.templates.weapons.user.*
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import kotlin.reflect.full.declaredMemberProperties

object Coatings : IGlobalEntities {
    fun getUserTemplateItems(player: IPlayerConnection) =
        Coatings::class.declaredMemberProperties
            .map { (it.get(this) as IEntity).clone() }
            .onEach {
                it.templateAccessor!!.template = WeaponPaintUserItemTemplate()

                //todo check if user has this item
                it.addComponent(UserGroupComponent(player.user.id))
            }

    val None = entity(-172249613) {
        templateAccessor(WeaponPaintMarketItemTemplate(), "garage/cover/none")
        component(MarketItemGroupComponent(-172249613))
    }
}