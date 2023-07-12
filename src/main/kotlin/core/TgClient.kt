package core

import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.serialization.*
import io.ktor.util.network.*
import model.BodyResponse

class TgClient(val engine: Engine) {
    constructor(token: String) : this(engine = Engine(token))
    suspend inline fun <reified T : BodyResponse> request(uri: String): BodyResponse = try {
        val client = this.engine.client()
        val rq = client.get("https://api.telegram.org/bot${this.engine.token}/$uri").body<T>()
        client.close()
        rq
    } catch (e: JsonConvertException) {
        throw JsonConvertException(e.localizedMessage, e)
    } catch (e: UnresolvedAddressException) {
        throw UnresolvedAddressException()
    } catch (e: Exception) {
        throw Exception("Что-то пошло не так: ${e.localizedMessage}", e)
    }
}