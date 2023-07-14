package core

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Display(private val listnableSource: ListnableSource) {
    suspend fun watch(block: suspend () -> Unit): Unit = withContext(Dispatchers.Default) {
        try {
            listnableSource.listen {
                launch { block.invoke() }
            }
        } catch (e: Exception) {
            println("Чёт случилось: ${e.localizedMessage}, ${e.cause}")
        }
    }
}