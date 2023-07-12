package request

import core.TgClient
import io.ktor.serialization.*
import kotlinx.coroutines.runBlocking
import model.BodyResponse
import model.Error
import model.GetUpdates

class RqGetUpdates(private val response: BodyResponse) : Request {
    constructor(tgClient: TgClient) : this(
        response = runBlocking {
            val getUpdates = "getUpdates"
            try {
                tgClient.request<GetUpdates>(getUpdates)
            } catch (e: JsonConvertException) {
                tgClient.request<Error>(getUpdates)
            } catch (e: Exception) {
                throw Exception(e.localizedMessage, e)
            }
        }
    )
    override fun send(): GetUpdates = if (this.response is Error) {
        throw Exception("getUpdates: error_code = ${this.response.errorCode}, " +
                "description = ${this.response.description}")
    } else {
        this.response as GetUpdates
    }
}