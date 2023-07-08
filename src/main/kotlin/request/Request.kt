package request

import model.Structure

interface Request {
    suspend fun send(): Structure
}