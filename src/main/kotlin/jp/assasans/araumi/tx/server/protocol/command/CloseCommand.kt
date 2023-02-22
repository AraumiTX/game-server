package jp.assasans.araumi.tx.server.protocol.command

import jp.assasans.araumi.tx.server.network.IPlayerConnection

class CloseCommand(
  val reason: String
) : ICommand {
  override suspend fun execute(connection: IPlayerConnection) {
    TODO("Not yet implemented")
  }
}
