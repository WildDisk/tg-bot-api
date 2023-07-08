package request

import core.TgClient
import io.ktor.serialization.*
import model.Error
import model.GetUpdates
import model.Structure

class RqGetUpdates(private val client: TgClient) : Request {
    override suspend fun send(): Structure = try {
        this.client.request<GetUpdates>("getUpdates")
    } catch (e: JsonConvertException) {
        this.client.request<Error>("getUpdates")
    } catch (e: Exception) {
        throw Exception(e.localizedMessage, e)
    }
}