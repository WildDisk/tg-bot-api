package request

import model.BodyResponse

interface Request {
    suspend fun send(): BodyResponse
}