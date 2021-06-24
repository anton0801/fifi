package app.beer.fifi.utils

import android.app.Activity
import android.content.Context
import android.net.wifi.WifiManager
import android.text.format.Formatter
import android.view.View
import com.google.android.material.snackbar.Snackbar
import java.net.InetAddress

object Helper {

    // snackbars
    fun showSnackbar(context: Activity, text: String, duration: Int = Snackbar.LENGTH_SHORT) {
        Snackbar.make(context, context.findViewById(android.R.id.content), text, duration).show()
    }

    fun showSnackbarWithAction(
        context: Activity,
        text: String,
        actionText: String,
        duration: Int = Snackbar.LENGTH_SHORT,
        actionCallback: (View) -> Unit
    ) {
        Snackbar.make(context, context.findViewById(android.R.id.content), text, duration)
            .setAction(actionText, actionCallback)
            .show()
    }

    /**
     * @param context
     * @return the ip address of user
     * */
    fun getIpAddress(context: Context): String? {
        val wifiManager =
            context.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        return Formatter.formatIpAddress(wifiManager.connectionInfo.ipAddress)
    }

}