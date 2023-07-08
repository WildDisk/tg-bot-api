package model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Error(
    @SerialName("ok") val ok: Boolean,
    @SerialName("error_code") val errorCode: String,
    @SerialName("description") val description: String
) : Structure
