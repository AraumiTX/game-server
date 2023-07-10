package jp.assasans.araumi.tx.server.ecs.globalEntities

import kotlin.reflect.KClass
import kotlin.reflect.full.declaredMemberProperties
import org.koin.core.component.KoinComponent
import jp.assasans.araumi.tx.server.ecs.entities.IEntity
import jp.assasans.araumi.tx.server.extensions.inject
import jp.assasans.araumi.tx.server.network.IPlayerConnection
import jp.assasans.araumi.tx.server.utils.IClassScanner

interface IGlobalEntities {
  fun getMarketTemplateItems() =
    (this::class as KClass<IGlobalEntities>).declaredMemberProperties
      .map { it.get(this) as IEntity }
}

interface IUserGlobalEntities : IGlobalEntities {
  fun getUserTemplateItems(player: IPlayerConnection): List<IEntity>
}

object GlobalEntities : KoinComponent {
  private val classScanner: IClassScanner by inject()

  fun getAllUserTemplateItems(player: IPlayerConnection) =
    classScanner.getSubtypesOf(IUserGlobalEntities::class)
      .map {
        it.objectInstance!!
      }.flatMap {
        val items = it.getUserTemplateItems(player)
        player.player.userTemplateItems[it::class] = items

        items
      }
}
