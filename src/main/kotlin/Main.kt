import core.Endpoint
import core.SuspendRequest
import core.TgClient
import model.GetUpdates
import request.RqGetMe
import request.RqGetUpdates
import request.RqSendMessage

fun main() {
    val tg = TgClient("6369961965:AAFR4c4sZp7bz1XYpciWyDNLplMcnPAzbv0")
    println(Endpoint(SuspendRequest(RqGetMe(tg))))
    println(Endpoint(SuspendRequest(RqGetUpdates(tg))))
    val getUpdates: GetUpdates = SuspendRequest(RqGetUpdates(tg)).request() as GetUpdates
    val chatId = try {
        getUpdates.result[0].message.chat.id
    } catch (e: Exception) {
        println(e.localizedMessage)
        -1
    }
    println(Endpoint(SuspendRequest(RqSendMessage(tg, chatId, "/start"))))
//    println(tg.request<String>("sendMessage?chat_id=$chatId&text=/start"))
    tg.close()
}