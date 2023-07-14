package app

import model.BodyResponse
import model.GetUpdates
import request.IsError
import request.RqSendMessage

class BotAnswer(private val info: BotInfo) : Info {
    private var updateId: Long = 0
    override suspend fun fetch(): BodyResponse = try {
        val getUpdates = this.info.fetch() as GetUpdates
        if (getUpdates.result.last().message.sticker.emoji != "" &&
            getUpdates.result.last().updateId != updateId) {
            updateId = getUpdates.result.last().updateId
            IsError(
                RqSendMessage(
                    this@BotAnswer.info.tg,
                    this@BotAnswer.info.chatId,
                    getUpdates.result.last().message.sticker.emoji
                )
            ).send()
        } else {
            getUpdates
        }
    } catch (e: Exception) {
        throw Exception(e.localizedMessage, e)
    }
}