package app

import core.Display
import core.Endpoint
import core.ListnableSource
import core.TgClient
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val tg = TgClient("6369961965:AAFR4c4sZp7bz1XYpciWyDNLplMcnPAzbv0")
//    val tg = TgClient("1369961965:AAFR4c4sZp7bz1XYpciWyDNLplMcnPAzbv0")
    val chatId: Long = 471280610
    val bot = BotAnswer(BotInfo(tg, chatId))
    Display(ListnableSource(500)).watch {
        View(
            Endpoint(
                bot.fetch()
            )
        )
    }
}