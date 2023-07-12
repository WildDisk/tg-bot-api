import core.Endpoint
import core.TgClient
import request.RqGetMe
import request.RqGetUpdates
import request.RqSendMessage

fun main() {
    val tg = TgClient("6369961965:AAFR4c4sZp7bz1XYpciWyDNLplMcnPAzbv0")
//    val tg = TgClient("1369961965:AAFR4c4sZp7bz1XYpciWyDNLplMcnPAzbv0")
    println(Endpoint(RqGetMe(tg)))
    val getUpdates = RqGetUpdates(tg)
    println(Endpoint(getUpdates))
    val chatId = try {
        getUpdates.send().result[0].message.chat.id
    } catch (e: Exception) {
        println(e.localizedMessage)
        -1
    }
    println(Endpoint(RqSendMessage(tg, chatId, "/start")))
    println(Endpoint(RqSendMessage(tg, 471280610, "start")))
}