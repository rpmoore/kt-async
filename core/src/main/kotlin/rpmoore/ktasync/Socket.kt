/*
 * *
 *  * Copyright of Ryan Moore (c) 2018.
 * /
 *
 */

package rpmoore.ktasync

import rpmoore.ktasync.buffer.Sink
import rpmoore.ktasync.buffer.Source

interface Socket {
    // buffer interface should be used here?  Okio's? Netty's? Raw Java?
    //suspend fun read(buffer: Buf): Int

    fun sink(): Sink
    fun source(): Source
    fun close()
}