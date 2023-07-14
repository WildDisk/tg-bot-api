package app

import model.BodyResponse

interface Info {
    suspend fun fetch() : BodyResponse
}