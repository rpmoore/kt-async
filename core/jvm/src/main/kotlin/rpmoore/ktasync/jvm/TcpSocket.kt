/*
 * *
 *  * Copyright of Ryan Moore (c) 2019.
 * /
 *
 */

package rpmoore.ktasync.jvm

import rpmoore.ktasync.Socket
import java.io.Closeable
import java.nio.ByteBuffer
import java.nio.channels.AsynchronousSocketChannel
import java.nio.channels.CompletionHandler
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class TcpSocket(private val socket: AsynchronousSocketChannel) : Socket, Closeable {

    override suspend fun write() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun close() {
        socket.close()
    }

    private suspend fun AsynchronousSocketChannel.asyncRead(buffer: ByteBuffer): Int {
        return suspendCoroutine { continuation ->
           this.read(buffer, continuation, ReadCompletionHandler)
        }
    }

    object ReadCompletionHandler : CompletionHandler<Int, Continuation<Int>> {
        override fun completed(result: Int, attachment: Continuation<Int>) {
            attachment.resume(result)
        }

        override fun failed(exc: Throwable, attachment: Continuation<Int>) {
            attachment.resumeWithException(exc)
        }
    }
}