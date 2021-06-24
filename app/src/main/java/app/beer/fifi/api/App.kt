package app.beer.fifi.api

import android.app.Application
import app.beer.fifi.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class App : Application() {

    private lateinit var apiService: ApiService

    override fun onCreate() {
        super.onCreate()

        val httpInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(httpInterceptor)
            .addInterceptor {
                val newRequest = it.request().newBuilder()
                    .addHeader("Authorization", "BjdJ7hhWdnc1HualT5lyrghSlzEXseWn6pGiQU0w")
                    .build()
                return@addInterceptor it.proceed(newRequest)
            }
            .callTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()

        apiService = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    fun getApiService() = apiService

}