package core

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import request.ListnableSource

class Display(private val listnableSource: ListnableSource) {
    suspend fun lookup(block: () -> Unit) = withContext(Dispatchers.Default) {
        try {
            listnableSource.listen {
                block.invoke()
            }
        } catch (e: Exception) {
            println("Чёт случилось: ${e.localizedMessage}")
        }
    }
}