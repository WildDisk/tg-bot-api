package request

import core.TgClient
import io.ktor.serialization.*
import model.BodyResponse
import model.Error
import model.GetUpdates

class RqGetUpdates(private val tg: TgClient, private val chatId: Long) : Request {
    override suspend fun send(): BodyResponse {
        val getUpdates = "getUpdates?chat_id=$chatId"
        return try {
            tg.request<GetUpdates>(getUpdates)
        } catch (e: JsonConvertException) {
            tg.request<Error>(getUpdates)
        } catch (e: Exception) {
            throw Exception(e.localizedMessage, e)
        }
    }
}