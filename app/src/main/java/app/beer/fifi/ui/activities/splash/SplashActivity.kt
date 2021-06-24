package app.beer.fifi.ui.activities.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.beer.fifi.databinding.ActivitySplashBinding
import app.beer.fifi.ui.activities.auth.auth.AuthActivity
import app.beer.fifi.utils.SharedManager

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    private lateinit var sharedManager: SharedManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedManager = SharedManager(this)

        // get user if logged
        if (!sharedManager.isAuth()) {
            startActivity(Intent(this, AuthActivity::class.java))
            finish()
        } else {
            // get data of user
            //            startActivity(Intent(this, MainActivity::class.java))
            //            finish()
        }
    }

}