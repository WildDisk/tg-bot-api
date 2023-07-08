package request

import core.TgClient
import io.ktor.serialization.*
import model.Structure
import model.Error
import model.GetMe

class RqGetMe(private val client: TgClient) : Request {
    override suspend fun send(): Structure = try {
        this.client.request<GetMe>("getMe")
    } catch (e: JsonConvertException) {
        this.client.request<Error>("getMe")
    } catch (e: Exception) {
        throw Exception(e.localizedMessage, e)
    }
}