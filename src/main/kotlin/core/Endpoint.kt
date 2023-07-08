package core

import kotlinx.coroutines.runBlocking
import request.Request

class Endpoint(private val result: String) {
    constructor(suspendRequest: SuspendRequest) : this(
        result = try {
            suspendRequest.request().toString()
        } catch (e: Exception) {
            e.localizedMessage
        }
    )
    constructor(request: Request) : this(
        result = try {
            runBlocking { request.send().toString() }
        } catch (e: Exception) {
            e.localizedMessage
        }
    )
    override fun toString(): String = this.result
}