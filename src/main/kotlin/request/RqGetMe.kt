package request

import core.TgClient
import io.ktor.serialization.*
import kotlinx.coroutines.runBlocking
import model.BodyResponse
import model.Error
import model.GetMe

class RqGetMe(private val response: BodyResponse) : Request {
    constructor(tgClient: TgClient) : this(
        response = runBlocking {
            try {
                tgClient.request<GetMe>("getMe")
            } catch (e: JsonConvertException) {
                tgClient.request<Error>("getMe")
            } catch (e: Exception) {
                throw Exception(e.localizedMessage, e)
            }
        }
    )
    override fun send(): BodyResponse = if (this.response is Error) {
        throw Exception("getMe: error_code = ${this.response.errorCode}, " +
                "description = ${this.response.description}")
    } else {
        this.response as GetMe
    }
}