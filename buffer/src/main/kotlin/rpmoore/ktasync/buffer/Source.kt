/*
 * *
 *  * Copyright of Ryan Moore (c) 2019.
 * /
 *
 */

package rpmoore.ktasync.buffer

interface Source {
    suspend fun read()
}