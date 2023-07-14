package request

import core.TgClient
import io.ktor.serialization.*
import model.BodyResponse
import model.Error
import model.GetMe

class RqGetMe(private val tg: TgClient) : Request {
    override suspend fun send(): BodyResponse {
        val getMe = "getMe"
        return try {
            tg.request<GetMe>(getMe)
        } catch (e: JsonConvertException) {
            tg.request<Error>(getMe)
        } catch (e: Exception) {
            throw Exception(e.localizedMessage, e)
        }
    }
}