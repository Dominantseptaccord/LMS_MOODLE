package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityScheduleBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import java.util.Calendar


class ScheduleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScheduleBinding
    private lateinit var scheduleAdapter: ScheduleAdapter
    private lateinit var lessons: List<Lesson>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScheduleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //
        val auth = FirebaseAuth.getInstance()
        val user = auth.currentUser
        binding.recyclerViewer.layoutManager = LinearLayoutManager(this)
        val database = FirebaseDatabase.getInstance().reference
        val dayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
        val dayString = WeekDay.from(dayOfWeek).name
        binding.weekOfDay.text = dayString
        if (user == null) {
            Toast.makeText(this, "User not logged in", Toast.LENGTH_SHORT).show()
            return
        }
        database.child("SEschedule").child(dayString)
            .get()
            .addOnSuccessListener { snapshot ->
                if (snapshot.exists()) {
                    val lessonsList = mutableListOf<Lesson>()
                    for (lessonSnapshot in snapshot.children) {
                        val time = lessonSnapshot.key ?: ""
                        val subject = lessonSnapshot.child("subject").value.toString()
                        val teacher = lessonSnapshot.child("teacher").value.toString()
                        val room = lessonSnapshot.child("room").value.toString()

                        val lesson = Lesson(time, subject, teacher, room)
                        lessonsList.add(lesson)
                    }
                    lessons = lessonsList
                    scheduleAdapter = ScheduleAdapter(lessons)
                    binding.recyclerViewer.adapter = scheduleAdapter
                }
            }
            .addOnFailureListener {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
    }
}