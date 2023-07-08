package core

import kotlinx.coroutines.runBlocking
import model.Structure
import request.Request

class SuspendRequest(private val request: Request) {
    fun request(): Structure = try {
        runBlocking { this@SuspendRequest.request.send() }
    } catch (e: Exception) {
        throw Exception(e.localizedMessage, e)
    }
    override fun toString(): String = this.request().toString()
}