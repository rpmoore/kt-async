/*
 * *
 *  * Copyright of Ryan Moore (c) 2018.
 * /
 *
 */

package rpmoore.ktasync

import java.util.concurrent.TimeUnit

interface Client<T: Socket> {
    /**
     * Attempts to connect to a remote system and return a socket to that system.
     */
    suspend fun open(): T

    /**
     * Opens a connection to a remote system, but with a timeout.  If the connection request times out, a TimeoutException will be thrown
     */
    suspend fun open(time: Int, unit: TimeUnit): T
}