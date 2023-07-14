package request

import model.BodyResponse
import model.Error

class IsError(private val request: Request) : Request {
    override suspend fun send(): BodyResponse {
        val response = this.request.send()
        return if (response is Error) {
            throw Exception("error_code = ${response.errorCode}, description = ${response.description}")
        } else {
            response
        }
    }
}