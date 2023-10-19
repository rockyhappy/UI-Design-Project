package com.example.userinterfacesample

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.content.ContextCompat
import com.example.userinterfacesample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.signUp
        binding.signUp.setOnClickListener {
            binding.signUp.setTextColor(ContextCompat.getColor(this, R.color.green))
            Handler(Looper.getMainLooper()).postDelayed(
                {
                    binding.signUp.setTextColor(Color.WHITE)
                    intent = Intent(this,MainActivity2::class.java)
                    startActivity(intent)
                },100
            )

        }
    }
}