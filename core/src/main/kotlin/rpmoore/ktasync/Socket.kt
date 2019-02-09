/*
 * *
 *  * Copyright of Ryan Moore (c) 2018.
 * /
 *
 */

package rpmoore.ktasync

interface Socket {
    // buffer interface should be used here?  Okio's? Netty's? Raw Java?
    //suspend fun read(buffer: Buf): Int

    suspend fun write()
}