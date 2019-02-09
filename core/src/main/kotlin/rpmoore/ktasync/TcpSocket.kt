/*
 * *
 *  * Copyright of Ryan Moore (c) 2018.
 * /
 *
 */

package rpmoore.ktasync

import java.nio.Buffer
import java.nio.ByteBuffer
import java.nio.channels.AsynchronousSocketChannel
import java.nio.channels.CompletionHandler
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class TcpSocket(private val socket: AsynchronousSocketChannel) : Socket {
    override suspend fun read(buffer: ByteBuffer): Int {
        return socket.asyncRead(buffer)
    }

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