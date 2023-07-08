package request

import core.TgClient
import io.ktor.serialization.*
import model.Error
import model.SendMessage
import model.Structure

class RqSendMessage(
    private val client: TgClient,
    private val chatId: Long,
    private val text: String
) : Request {
    override suspend fun send(): Structure = try {
        this.client.request<SendMessage>("sendMessage?chat_id=$chatId&text=$text")
    } catch (e: JsonConvertException) {
        this.client.request<Error>("sendMessage?chat_id=$chatId&text=$text")
    } catch (e: Exception) {
        throw Exception(e.localizedMessage, e)
    }
}