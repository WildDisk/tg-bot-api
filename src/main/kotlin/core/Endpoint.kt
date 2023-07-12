package core

import model.BodyResponse
import request.Request

class Endpoint(private val result: String) {
    constructor(response: BodyResponse) : this(result = response.toString())
    constructor(request: Request) : this(
        result = try {
            request.send().toString()
        } catch (e: Exception) {
            e.localizedMessage
        }
    )
    override fun toString(): String = this.result
}