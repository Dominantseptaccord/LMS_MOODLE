package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val auth = FirebaseAuth.getInstance()
        val user = auth.currentUser
        binding.user.text = user!!.email
        binding.coursesOver.setOnClickListener {
            startActivity(Intent(this,HomeActivity::class.java))
        }
        binding.scheduleOver.setOnClickListener {
            startActivity(Intent(this,ScheduleActivity::class.java))
        }
    }
}
