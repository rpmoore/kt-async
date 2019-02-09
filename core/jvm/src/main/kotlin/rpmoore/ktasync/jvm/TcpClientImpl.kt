/*
 * *
 *  * Copyright of Ryan Moore (c) 2018.
 * /
 *
 */

package rpmoore.ktasync.jvm

import rpmoore.ktasync.Client
import java.nio.channels.AsynchronousSocketChannel

class TcpClientImpl : Client<TcpSocket> {

    private val socketChannel = AsynchronousSocketChannel.open()

    override suspend fun open(): TcpSocket {

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun open(timeout: Int): TcpSocket {

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}