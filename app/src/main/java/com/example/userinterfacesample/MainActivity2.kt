package com.example.userinterfacesample

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.content.ContextCompat
import com.example.userinterfacesample.databinding.ActivityMain2Binding
import com.example.userinterfacesample.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.signUp.setOnClickListener {
            binding.signUp.setTextColor(ContextCompat.getColor(this, R.color.green))
            Handler(Looper.getMainLooper()).postDelayed(
                {
                    binding.signUp.setTextColor(Color.WHITE)
                    intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                    finish()
                },100
            )

        }

    }
}