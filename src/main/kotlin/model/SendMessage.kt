package model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SendMessage(
    @SerialName("ok") val ok: Boolean,
    @SerialName("result") val result: Result
) : Structure {
    @Serializable
    data class Result(
        @SerialName("message_id") val messageId: Long,
        @SerialName("from") val from: From,
        @SerialName("chat") val chat: Chat,
        @SerialName("date") val date: Long,
        @SerialName("text") val text: String,
        @SerialName("entities") val entities: List<Entities> = emptyList()
    ) {
        @Serializable
        data class From(
            @SerialName("message_id") val id: Long,
            @SerialName("is_bot") val isBot: Boolean,
            @SerialName("first_name") val firstName: String,
            @SerialName("username") val username: String
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