/*
 * *
 *  * Copyright of Ryan Moore (c) 2018.
 * /
 *
 */

package rpmoore.ktasync.impl

import rpmoore.ktasync.Client
import rpmoore.ktasync.TcpSocket
import java.nio.channels.AsynchronousSocketChannel
import java.util.concurrent.TimeUnit

class TcpClientImpl : Client<TcpSocket> {

    private val socketChannel = AsynchronousSocketChannel.open()

    override suspend fun open(): TcpSocket {

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun open(time: Int, unit: TimeUnit): TcpSocket {

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}