package request

import model.BodyResponse

interface Request {
    fun send(): BodyResponse
}