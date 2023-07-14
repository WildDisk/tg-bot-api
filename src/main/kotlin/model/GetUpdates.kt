package model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetUpdates(
    @SerialName("ok") val ok: Boolean,
    @SerialName("result") val result: List<Result>
) : BodyResponse {
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
            @SerialName("text") val text: String = "",
            @SerialName("sticker") val sticker: Sticker = Sticker(),
            @SerialName("entities") val entities: List<Entities> = emptyList(),
            @SerialName("photo") val photo: List<Photo> = emptyList(),
            @SerialName("voice") val voice: Voice = Voice(),
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
            @Serializable
            data class Sticker(
                @SerialName("width") val width: Int = 0,
                @SerialName("height") val height: Int = 0,
                @SerialName("emoji") val emoji: String = "",
                @SerialName("set_name") val setName: String = "",
                @SerialName("is_animated") val isAnimated: Boolean = false,
                @SerialName("is_video") val isVideo: Boolean = false,
                @SerialName("type") val type: String = "",
                @SerialName("thumbnail") val thumbnail: Thumbnail = Thumbnail(),
                @SerialName("thumb") val thumb: Thumb = Thumb(),
                @SerialName("file_id") val fileId: String = "",
                @SerialName("file_unique_id") val fileUniqueId: String = "",
                @SerialName("file_size") val fileSize: Long = 0,
            ) {
                @Serializable
                data class Thumbnail(
                    @SerialName("file_id") val fileId: String = "",
                    @SerialName("file_unique_id") val fileUniqueId: String = "",
                    @SerialName("file_size") val fileSize: Long = 0,
                    @SerialName("width") val width: Int = 0,
                    @SerialName("height") val height: Int = 0
                )
                @Serializable
                data class Thumb(
                    @SerialName("file_id") val fileId: String = "",
                    @SerialName("file_unique_id") val fileUniqueId: String = "",
                    @SerialName("file_size") val fileSize: Long = 0,
                    @SerialName("width") val width: Int = 0,
                    @SerialName("height") val height: Int = 0
                )
            }
            @Serializable
            data class Photo(
                @SerialName("file_id") val fileId: String = "",
                @SerialName("file_unique_id") val fileUniqueId: String = "",
                @SerialName("file_size") val fileSize: Long = 0,
                @SerialName("width") val width: Int = 0,
                @SerialName("height") val height: Int = 0
            )
            @Serializable
            data class Voice(
                @SerialName("duration") val duration: Int = 0,
                @SerialName("mime_type") val mimeType: String = "",
                @SerialName("file_id") val fileId: String = "",
                @SerialName("file_unique_id") val fileUniqueId: String = "",
                @SerialName("file_size") val fileSize: Long = 0
            )
        }
    }
}
