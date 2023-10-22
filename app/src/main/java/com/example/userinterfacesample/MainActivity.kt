package com.example.userinterfacesample

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.userinterfacesample.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.signUp.setOnClickListener {
            binding.signUp.setTextColor(ContextCompat.getColor(this, R.color.green))
            Handler(Looper.getMainLooper()).postDelayed(
                {
                    binding.signUp.setTextColor(Color.WHITE)
                    intent = Intent(this,MainActivity2::class.java)
                    startActivity(intent)
                    finish()
                },100
            )

        }
        binding.btn.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                try {
                    val request = LoginRequest("eve.holt@reqres.in", "cityslicka")
                    val response = RetrofitInstance.apiService.login(request)

                    if (response.isSuccessful) {
                        val loginResponse = response.body()
                        if (loginResponse != null) {
                            val token = loginResponse.token
                            Log.d("Error", token.toString())
                            runOnUiThread {
                                Toast.makeText(this@MainActivity,token.toString(),Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                } catch (e: Exception) {
                   // I Will do something if an error came
                }
            }

        }
    }
}