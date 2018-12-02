/*
 * *
 *  * Copyright of Ryan Moore (c) 2018.
 * /
 *
 */

package rpmoore.ktasync

import java.io.Closeable // TODO need to think about if we're going to target more than just the jvm

interface Socket : Closeable {
    // buffer interface should be used here?  Okio's? Netty's? Raw Java?
    suspend fun read()

    suspend fun write()
}