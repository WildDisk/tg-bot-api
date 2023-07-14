import core.Display
import core.DoSomething
import core.TgClient
import kotlinx.coroutines.*
import request.ListnableSource

fun main() = runBlocking {
    val tg = TgClient("6369961965:AAFR4c4sZp7bz1XYpciWyDNLplMcnPAzbv0")
//    val tg = TgClient("1369961965:AAFR4c4sZp7bz1XYpciWyDNLplMcnPAzbv0")
    val chatId: Long = 471280610
    val doThat = DoSomething(tg, chatId)
    Display(ListnableSource(500)).lookup {
        launch {
            doThat.doSomething()
        }
    }
}