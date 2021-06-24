package app.beer.fifi.api

import app.beer.fifi.models.auth.Auth
import app.beer.fifi.models.auth.AuthResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("login")
    fun login(@Body auth: Auth): Call<AuthResponse>

    @POST("register")
    fun register()

}