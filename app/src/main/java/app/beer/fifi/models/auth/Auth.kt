package app.beer.fifi.models.auth

import app.beer.fifi.models.BaseModelResponse
import com.google.gson.annotations.SerializedName

data class Auth(
    var email: String? = null,
    var nick_name: String? = null,
    val password: String = "",
    val ipAddress: String = ""
)

data class AuthResponse(
    @SerializedName("data")
    val id: Int = 0
) : BaseModelResponse()
