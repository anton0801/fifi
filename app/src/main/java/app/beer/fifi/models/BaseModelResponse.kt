package app.beer.fifi.models

import com.google.gson.annotations.SerializedName

open class BaseModelResponse {
    @SerializedName("success")
    val success: Boolean = false
    @SerializedName("message")
    val message: String = ""
}