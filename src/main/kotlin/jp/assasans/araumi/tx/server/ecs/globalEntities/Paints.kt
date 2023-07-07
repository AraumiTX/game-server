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

object Paints : IGlobalEntities {
    fun getUserTemplateItems(player: IPlayerConnection) =
        Paints::class.declaredMemberProperties
            .map { (it.get(this) as IEntity).clone() }
            .onEach {
                it.templateAccessor!!.template = TankPaintUserItemTemplate()

                //todo check if user has this item
                it.addComponent(UserGroupComponent(player.user.id))
            }

    val Green = entity(-20020438) {
        templateAccessor(TankPaintMarketItemTemplate(), "garage/paint/green")
        component(MarketItemGroupComponent(-20020438))
    }
}