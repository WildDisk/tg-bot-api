package model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetMe(
    @SerialName("ok") private val ok: Boolean,
    @SerialName("result") private val result: Result
) : Structure {
    @Serializable
    data class Result(
        @SerialName("id") private val id: Long,
        @SerialName("is_bot") private val isBot: Boolean,
        @SerialName("first_name") private val firstName: String,
        @SerialName("username") private val username: String,
        @SerialName("can_join_groups") private val canJoinGroups: Boolean,
        @SerialName("can_read_all_group_messages") private val canReadAllGroupMessages: Boolean,
        @SerialName("supports_inline_queries") private val supportsInlineQueries: Boolean
    )
}
