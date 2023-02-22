package jp.assasans.araumi.tx.server.protocol.command

import jp.assasans.araumi.tx.server.network.IPlayerConnection

interface ICommand {
  suspend fun execute(connection: IPlayerConnection)
}
