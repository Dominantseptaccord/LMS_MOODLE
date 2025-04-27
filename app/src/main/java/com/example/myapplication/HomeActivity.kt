package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityCourseRecycleBinding
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCourseRecycleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCourseRecycleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val auth = FirebaseAuth.getInstance()
        val user = auth.currentUser

        val courseList = listOf(
            Course("Native Mobile Development","Gulsipat Abisheva"),
            Course("Advanced Databases (NoSQL)","Abdiramanov Orisbay"),
            Course("Russian Language 2 (C1)","Malikova Zhanar"),
            Course("Computational Mathematics","Gulim Sagimbayeva"),
            Course("Computer Organisation and Architecture","Yespenbetova Dana"),
            Course("WEB Technologies 2 (Back End)","Rakhimzhanov Daniyar"),
        )
        binding.toHome.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
        val adapter = CourseAdapter(courseList)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }
}
