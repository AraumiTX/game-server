package jp.assasans.araumi.tx.server.protocol.codec.complex

import kotlin.reflect.KClass
import jp.assasans.araumi.tx.server.network.ProtocolBuffer
import jp.assasans.araumi.tx.server.protocol.codec.Codec
import jp.assasans.araumi.tx.server.protocol.codec.info.TypeCodecInfo
import jp.assasans.araumi.tx.server.protocol.command.CommandCode
import jp.assasans.araumi.tx.server.protocol.command.ICommand
import jp.assasans.araumi.tx.server.protocol.getCodec

class CommandCodec : Codec<ICommand>() {
  private val commandToCode = mutableMapOf<KClass<out ICommand>, CommandCode>()
  private val codeToCommand = mutableMapOf<CommandCode, KClass<out ICommand>>()

  override suspend fun encode(buffer: ProtocolBuffer, value: ICommand) {
    val type = value::class
    val code = requireNotNull(commandToCode[type]) { "Command $type is not registered" }

    protocol.getCodec<CommandCode>(TypeCodecInfo(CommandCode::class)).encode(buffer, code)
    protocol.getCodec<ICommand>(TypeCodecInfo(type)).encode(buffer, value)
  }

  override suspend fun decode(buffer: ProtocolBuffer): ICommand {
    val code = protocol.getCodec<CommandCode>(TypeCodecInfo(CommandCode::class)).decode(buffer)
    val type = requireNotNull(codeToCommand[code]) { "Command code $code is not registered" }

    return protocol.getCodec<ICommand>(TypeCodecInfo(type)).decode(buffer)
  }

  fun register(type: KClass<out ICommand>, code: CommandCode) {
    commandToCode[type] = code
    codeToCommand[code] = type
  }
}
