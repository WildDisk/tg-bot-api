package core

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

class ListnableSource(private val repeat: Long) {
    suspend fun listen(block: () -> Unit) {
        coroutineScope {
            while (true) {
                delay(repeat)
                try {
                    block.invoke()
                } catch (e: Exception) {
                    throw Exception(e.localizedMessage, e)
                }
            }
        }
    }
}