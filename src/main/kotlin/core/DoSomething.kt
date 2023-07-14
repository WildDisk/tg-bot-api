package core

import model.GetUpdates
import request.IsError
import request.RqGetUpdates
import request.RqSendMessage

class DoSomething(private val tg: TgClient, private val chatId: Long) {
    private var updateId: Long = 0
    suspend fun doSomething() {
        val getUpdates: GetUpdates = IsError(
            RqGetUpdates(
                this.tg,
                this.chatId
            )
        ).send() as GetUpdates
        println(getUpdates)
        if (getUpdates.result.last().message.sticker.emoji != "" &&
            getUpdates.result.last().updateId != updateId) {
            updateId = getUpdates.result.last().updateId
            IsError(
                RqSendMessage(
                    this.tg,
                    this.chatId,
                    getUpdates.result.last().message.sticker.emoji
                )
            ).send()
        }
    }
}