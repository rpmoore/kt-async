/*
 * *
 *  * Copyright of Ryan Moore (c) 2018.
 * /
 *
 */

package rpmoore.ktasync.impl

import rpmoore.ktasync.LoggerDelegate
import rpmoore.ktasync.Server
import rpmoore.ktasync.TcpSocket
import java.lang.RuntimeException
import java.net.InetSocketAddress
import java.nio.channels.AsynchronousServerSocketChannel
import java.nio.channels.AsynchronousSocketChannel
import java.nio.channels.CompletionHandler
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class TcpServerImpl : Server<TcpSocket> {
    private companion object {
        private val LOG by LoggerDelegate()
    }

    private val acceptHandler = AcceptHandler()

    private val serverSocket = AsynchronousServerSocketChannel.open().bind(InetSocketAddress("localhost", 5051))

    override suspend fun accept(): TcpSocket {
        return suspendCoroutine { continuation ->
            serverSocket.accept(continuation, acceptHandler)
        }
    }

    override fun close() {
        serverSocket.close()
    }

    class AcceptHandler : CompletionHandler<AsynchronousSocketChannel, Continuation<TcpSocket>> {
        override fun completed(result: AsynchronousSocketChannel?, continuation: Continuation<TcpSocket>) {
            if (result != null) {
                continuation.resume(TcpSocket(result))
            } else {
                LOG.error("accept returned with a null result")
                continuation.resumeWithException(RuntimeException("null result from CompletionHandler"))
            }
        }

        override fun failed(t: Throwable, continuation: Continuation<TcpSocket>) {
            LOG.error("Accept failed", t)
            continuation.resumeWithException(t)
        }
    }
}
