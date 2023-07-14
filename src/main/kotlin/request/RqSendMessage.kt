package request

import core.TgClient
import io.ktor.serialization.*
import model.BodyResponse
import model.Error
import model.SendMessage

class RqSendMessage(private val tg: TgClient, private val chatId: Long, private val text: String) : Request {
    override suspend fun send(): BodyResponse {
        val sendMessage = "sendMessage?chat_id=$chatId&text=$text"
        return try {
            tg.request<SendMessage>(sendMessage)
        } catch (e: JsonConvertException) {
            tg.request<Error>(sendMessage)
        } catch (e: Exception) {
            throw Exception(e.localizedMessage, e)
        }
    }
}