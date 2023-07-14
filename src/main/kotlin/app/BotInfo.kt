package app

import core.TgClient
import model.BodyResponse
import model.GetUpdates
import request.IsError
import request.RqGetUpdates

class BotInfo(val tg: TgClient, val chatId: Long) : Info {
    override suspend fun fetch(): BodyResponse = try {
        IsError(RqGetUpdates(this.tg, this.chatId)).send() as GetUpdates
    } catch (e: Exception) {
        throw Exception(e.localizedMessage, e)
    }
}