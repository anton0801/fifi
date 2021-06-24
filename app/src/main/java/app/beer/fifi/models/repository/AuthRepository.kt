package app.beer.fifi.models.repository

import app.beer.fifi.api.ApiService
import app.beer.fifi.models.auth.Auth
import app.beer.fifi.models.auth.AuthResponse
import app.beer.fifi.utils.AppRetrofitCallback
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AuthRepository(private val apiService: ApiService) {

    fun login(auth: Auth, onResponse: (AuthResponse) -> Unit) {
        GlobalScope.launch(Dispatchers.IO) {
            apiService.login(auth).enqueue(AppRetrofitCallback<AuthResponse> {
                onResponse(it.body()!!)
            })
        }
    }

}