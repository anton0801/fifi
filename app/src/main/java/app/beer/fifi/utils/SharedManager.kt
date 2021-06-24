package app.beer.fifi.utils

import android.content.Context

class SharedManager(private val context: Context) {

    private var sharedPreferences =
        context.getSharedPreferences("fifi_preferences", Context.MODE_PRIVATE)
    private var editor = sharedPreferences.edit()

    fun putString(key: String, value: String) {
        editor.putString(key, value)
        editor.apply()
    }

    fun getString(key: String) = sharedPreferences.getString(key, "") ?: ""

    fun putBoolean(key: String, value: Boolean) {
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun getBoolean(key: String) = sharedPreferences.getBoolean(key, false)

    fun isAuth() = getBoolean(Constants.IS_USER_AUTH)

}