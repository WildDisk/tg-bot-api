package request

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

class ListnableSource(private val repeate: Long) {
    suspend fun listen(block: () -> Unit) {
        coroutineScope {
            while (true) {
                delay(repeate)
//                launch {
                    try {
                        block.invoke()
                    } catch (e: Exception) {
                        throw Exception(e.localizedMessage, e)
                    }
//                }
            }
        }
    }
}