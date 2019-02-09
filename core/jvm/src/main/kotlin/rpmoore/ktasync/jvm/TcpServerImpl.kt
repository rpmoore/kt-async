/*
 * *
 *  * Copyright of Ryan Moore (c) 2018.
 * /
 *
 */

package rpmoore.ktasync.jvm

import rpmoore.ktasync.Server
import java.net.InetSocketAddress
import java.nio.channels.AsynchronousServerSocketChannel
import java.nio.channels.AsynchronousSocketChannel
import java.nio.channels.CompletionHandler
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * TODO: what kind of configuration settings should we provide and how should it be exposed? A builder DSL?
 * tcpServer {
 *     port = 5051
 *     hostname = localhost
 *     tcpFastStartup = false
 *     reuse = true
 *     keepalive = true
 *     sendBufferSize = 1_MB
 *     receiveBufferSize = 1_MB
 *     // are there any other options that we should expose here?
 * }
 *
 */
class TcpServerImpl : Server<TcpSocket> {
    private companion object {
        private val LOG by LoggerDelegate()
    }

    private val serverSocket = AsynchronousServerSocketChannel.open().bind(InetSocketAddress("localhost", 5051))

    override suspend fun accept(): TcpSocket {
        return suspendCoroutine { continuation ->
            serverSocket.accept(continuation, AcceptHandler)
        }
    }

    override fun close() {
        serverSocket.close()
    }

    object AcceptHandler : CompletionHandler<AsynchronousSocketChannel, Continuation<TcpSocket>> {
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
