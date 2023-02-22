package jp.assasans.araumi.tx.server.protocol.command

import jp.assasans.araumi.tx.server.ecs.IEntity
import jp.assasans.araumi.tx.server.network.IPlayerConnection

class EntityUnshareCommand(entity: IEntity) : EntityCommand(entity) {
  override suspend fun execute(connection: IPlayerConnection) {
    TODO("Not yet implemented")
  }
}
