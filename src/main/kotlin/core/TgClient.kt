package core

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.util.network.*
import kotlinx.serialization.json.Json

class TgClient(val token: String) {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                }
            )
        }
    }
    suspend inline fun <reified T> request(uri: String): T = try {
        this.client.get("https://api.telegram.org/bot${this.token}/$uri").body<T>()
    } catch (e: UnresolvedAddressException) {
        throw Exception("Что-то пошло не так: $e, message = ${e.message}", e)
    }
    fun close() : Unit = this.client.close()
}