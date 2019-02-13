/*
 * *
 *  * Copyright of Ryan Moore (c) 2019.
 * /
 *
 */

package rpmoore.ktasync.buffer

interface Sink {
    suspend fun write(byteArray: ByteArray): Int
}