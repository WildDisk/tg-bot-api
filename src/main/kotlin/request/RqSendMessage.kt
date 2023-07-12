package request

import core.TgClient
import io.ktor.serialization.*
import kotlinx.coroutines.runBlocking
import model.BodyResponse
import model.Error
import model.SendMessage

class RqSendMessage(private val response: BodyResponse) : Request {
    constructor(tgClient: TgClient, chatId: Long, text: String) : this(
        response = runBlocking {
            try {
                tgClient.request<SendMessage>("sendMessage?chat_id=$chatId&text=$text")
            } catch (e: JsonConvertException) {
                tgClient.request<Error>("sendMessage?chat_id=$chatId&text=$text")
            } catch (e: Exception) {
                throw Exception(e.localizedMessage, e)
            }
        }
    )
    override fun send(): SendMessage = if (this.response is Error) {
        throw Exception("sendMessage: error_code = ${this.response.errorCode}, " +
                "description = ${this.response.description}")
    } else {
        this.response as SendMessage
    }
}