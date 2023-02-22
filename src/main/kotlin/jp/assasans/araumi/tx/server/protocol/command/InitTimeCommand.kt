package jp.assasans.araumi.tx.server.protocol.command

import jp.assasans.araumi.tx.server.network.IPlayerConnection

class InitTimeCommand(
  val serverTime: Long
) : ICommand {
  override suspend fun execute(connection: IPlayerConnection) {
    TODO("Not yet implemented")
  }
}
