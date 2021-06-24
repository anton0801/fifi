package app.beer.fifi.ui.activities.auth.auth

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import app.beer.fifi.api.App
import app.beer.fifi.models.auth.Auth
import app.beer.fifi.models.auth.AuthResponse
import app.beer.fifi.models.repository.AuthRepository

class AuthViewModel(app: Application) : AndroidViewModel(app) {

    private val authRepository = AuthRepository((app as App).getApiService())

    private val _authResponseLiveData: MutableLiveData<AuthResponse> = MutableLiveData()
    val authResponseLiveData: LiveData<AuthResponse> = _authResponseLiveData

    fun login(auth: Auth) {
        authRepository.login(auth) {
            _authResponseLiveData.postValue(it)
        }
    }

}