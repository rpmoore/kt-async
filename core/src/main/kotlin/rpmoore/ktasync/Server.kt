/*
 * *
 *  * Copyright of Ryan Moore (c) 2018.
 * /
 *
 */

package rpmoore.ktasync

interface Server<T: Socket> {
    suspend fun accept(): T
    fun close()
}