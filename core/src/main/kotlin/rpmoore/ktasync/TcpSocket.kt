/*
 * *
 *  * Copyright of Ryan Moore (c) 2018.
 * /
 *
 */

package rpmoore.ktasync

import java.nio.channels.AsynchronousSocketChannel

class TcpSocket(private val socket: AsynchronousSocketChannel) : Socket {
    override suspend fun read() {

    }

    override suspend fun write() {

    }

    override fun close() {
        socket.close()
    }
}