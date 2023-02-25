package jp.assasans.araumi.tx.server.network

import java.nio.ByteBuffer
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.withContext
import io.ktor.network.sockets.*
import io.ktor.util.*
import io.ktor.utils.io.*
import mu.KotlinLogging
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import jp.assasans.araumi.tx.server.ecs.IEntity
import jp.assasans.araumi.tx.server.extensions.toHexString
import jp.assasans.araumi.tx.server.protocol.IProtocol
import jp.assasans.araumi.tx.server.protocol.buffer.OptionalMap
import jp.assasans.araumi.tx.server.protocol.codec.info.TypeCodecInfo
import jp.assasans.araumi.tx.server.protocol.command.ICommand
import jp.assasans.araumi.tx.server.protocol.getCodec
import jp.assasans.araumi.tx.server.protocol.toShareCommand
import jp.assasans.araumi.tx.server.utils.IWithCoroutineScope

interface IPlayerConnection : IWithCoroutineScope {
  val active: Boolean

  suspend fun receive()
  suspend fun decodeCommands()
  suspend fun sendCommands()

  fun send(command: ICommand)
  suspend fun close()
}

@Suppress("NOTHING_TO_INLINE")
inline fun IPlayerConnection.share(entity: IEntity) = send(entity.toShareCommand())

abstract class PlayerConnection(
  coroutineContext: CoroutineContext
) : IPlayerConnection, KoinComponent {
  private val logger = KotlinLogging.logger { }

  protected val protocol: IProtocol by inject()

  private val outgoingCommands: Channel<ICommand> = Channel(Channel.UNLIMITED)

  override val coroutineScope = CoroutineScope(coroutineContext + SupervisorJob())

  override fun send(command: ICommand) {
    outgoingCommands.trySend(command).getOrThrow()
  }

  override suspend fun sendCommands() {
    for(command in outgoingCommands) {
      val buffer = ProtocolBuffer(OptionalMap()) // TODO(Assasans): Object pooling

      protocol.getCodec<ICommand>(TypeCodecInfo(ICommand::class)).encode(buffer, command)

      val channel = ByteChannel(true)
      buffer.wrap(channel)
      send(channel.toByteArray())
    }
  }

  protected abstract suspend fun send(data: ByteArray)
}

class SocketPlayerConnection(
  val socket: Socket,
  coroutineContext: CoroutineContext
) : PlayerConnection(coroutineContext) {
  private val logger = KotlinLogging.logger { }

  private val reader: ByteReadChannel = socket.openReadChannel()
  private val writer: ByteWriteChannel = socket.openWriteChannel(autoFlush = true)

  // TODO: To allow logging of incoming packets
  private val decodeBuffer: ByteBuffer = ByteBuffer.allocate(4096)
  private val decodeChannel: ByteChannel = ByteChannel(autoFlush = true)

  override var active: Boolean = false
    private set

  override suspend fun receive() {
    active = true
    try {
      while(active) {
        decodeBuffer.clear()
        val read = reader.readAvailable(decodeBuffer)
        if(read == -1) break

        logger.trace { "Received $read bytes: ${decodeBuffer.slice(0, read).toHexString()}" }
        decodeChannel.writeFully(decodeBuffer.slice(0, read))
      }
    } catch(exception: Exception) {
      logger.error(exception) { "An exception occurred in the $this receive loop" }
    } finally {
      active = false
      logger.debug { "$this receive loop ended" }
    }
  }

  override suspend fun decodeCommands() {
    while(!decodeChannel.isClosedForRead) {
      val buffer = ProtocolBuffer(OptionalMap()) // TODO(Assasans): Object pooling
      require(buffer.unwrap(decodeChannel)) { "Failed to unwrap packet" }

      while(buffer.reader.availableForRead > 0) {
        // logger.trace { "decodeCommands protocol buffer available: ${buffer.reader.availableForRead}" }

        val command = protocol.getCodec<ICommand>(TypeCodecInfo(ICommand::class)).decode(buffer)
        logger.debug { "Received $command" }

        try {
          command.execute(this)
        } catch(exception: Exception) {
          logger.error(exception) { "Failed to execute command $command" }
        }
      }
    }
  }

  override suspend fun send(data: ByteArray) {
    writer.writeFully(data)
    logger.trace { "Sent ${data.size} bytes: ${data.toHexString()}" }
  }

  override suspend fun close() {
    active = false
    withContext(Dispatchers.IO) { socket.close() }
  }
}

suspend inline fun SocketPlayerConnection(socket: Socket) = SocketPlayerConnection(socket, coroutineContext)
