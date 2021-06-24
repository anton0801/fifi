package app.beer.fifi.utils

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AppRetrofitCallback<T>(private val onSuccess: (Response<T>) -> Unit) : Callback<T> {

    override fun onResponse(call: Call<T>, response: Response<T>) {
        if (response.body() != null && response.isSuccessful && (response.code() !in 400..404 && response.code() !in 500..504)) {
            onSuccess(response)
        }
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        Log.d(Constants.RETROFIT_ERROR, "onFailure: ${t.message}")
    }

}