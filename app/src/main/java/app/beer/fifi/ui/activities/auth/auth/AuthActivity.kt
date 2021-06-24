package app.beer.fifi.ui.activities.auth.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.util.Patterns
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import app.beer.fifi.MainActivity
import app.beer.fifi.R
import app.beer.fifi.databinding.ActivityAuthBinding
import app.beer.fifi.models.auth.Auth
import app.beer.fifi.ui.activities.auth.register.RegisterActivity
import app.beer.fifi.ui.activities.splash.SplashActivity
import app.beer.fifi.utils.Constants
import app.beer.fifi.utils.Helper
import app.beer.fifi.utils.SharedManager
import com.google.android.material.snackbar.Snackbar

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding

    private lateinit var vm: AuthViewModel

    private lateinit var sharedManger: SharedManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm = ViewModelProvider(this)[AuthViewModel::class.java]

        sharedManger = SharedManager(this)

        binding.passwordInput.transformationMethod = PasswordTransformationMethod()

        binding.notHaveAccount.setOnClickListener {
            // start activity for registration with fragments
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.authBtn.setOnClickListener {
            val login = binding.emailOrLoginInput.text.toString().trim()
            val password = binding.passwordInput.text.toString().trim()

            // checking if fields no son empties
            if (login.isEmpty()) {
                binding.emailOrLoginInput.error = getString(R.string.login_input_hint)
            }
            if (password.isEmpty()) {
                binding.passwordInput.error = getString(R.string.password_hint)
            }

            // if not empty do login
            if (login.isNotEmpty() && password.isNotEmpty()) {
                binding.progressBar.visibility = View.VISIBLE
                val auth = Auth(
                    password = binding.passwordInput.text.toString(),
                    ipAddress = Helper.getIpAddress(this).toString()
                )
                with(binding.emailOrLoginInput) {
                    // check login is email or nick name
                    if (Patterns.EMAIL_ADDRESS.matcher(text.toString()).matches()) {
                        auth.email = text.toString()
                    } else {
                        auth.nick_name = text.toString()
                    }
                }
                vm.login(auth)
            }
        }

        vm.authResponseLiveData.observe(this, Observer {
            // if login is success
            binding.progressBar.visibility = View.GONE
            if (it.success && it.message == Constants.LOGGED_SUCCESS) {
                // finish this activity and start main activity
                sharedManger.putBoolean(Constants.IS_USER_AUTH, true)
                finish()
                startActivity(Intent(this, SplashActivity::class.java))
            } else {
                Helper.showSnackbar(this, getString(R.string.some_went_wrong), Snackbar.LENGTH_LONG)
            }
        })
    }

}