package app.beer.fifi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.beer.fifi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bindind: ActivityMainBinding

    // подумать как лучше сделать анимированые эможи через gif или lottie
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindind.root)
    }

}