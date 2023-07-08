package model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetUpdates(
    @SerialName("ok") val ok: Boolean,
    @SerialName("result") val result: List<Result>
) : Structure {
    @Serializable
    data class Result(
        @SerialName("update_id") val updateId: Long,
        @SerialName("message")  val message: Message
    ) {
        @Serializable
        data class Message(
            @SerialName("message_id") val messageId: Long,
            @SerialName("from") val from: From,
            @SerialName("chat") val chat: Chat,
            @SerialName("date") val date: Long,
            @SerialName("text") val text: String,
            @SerialName("entities") val entities: List<Entities> = emptyList()
        ) {
            @Serializable
            data class From(
                @SerialName("id") val id: Long,
                @SerialName("is_bot") val isBot: Boolean,
                @SerialName("first_name") val firstName: String,
                @SerialName("username") val username: String,
                @SerialName("language_code") val languageCode: String
            )
            @Serializable
            data class Chat(
                @SerialName("id") val id: Long,
                @SerialName("first_name") val firstName: String,
                @SerialName("username") val username: String,
                @SerialName("type") val type: String
            )
            @Serializable
            data class Entities(
                @SerialName("offset") val offset: Int,
                @SerialName("length") val length: Int,
                @SerialName("type") val type: String
            )
        }
    }
}
