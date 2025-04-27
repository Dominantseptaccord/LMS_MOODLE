package com.example.myapplication

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
class ScheduleAdapter(private val lessons: List<Lesson>) : RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>() {

    class ScheduleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val timeTextView: TextView = itemView.findViewById(R.id.timeTextView)
        val subjectTextView: TextView = itemView.findViewById(R.id.subjectTextView)
        val teacherTextView: TextView = itemView.findViewById(R.id.teacherTextView)
        val roomTextView: TextView = itemView.findViewById(R.id.roomTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.schedule_item, parent, false)
        return ScheduleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        val lesson = lessons[position]
        holder.timeTextView.text = lesson.time
        holder.subjectTextView.text = lesson.subject
        holder.teacherTextView.text = lesson.teacher
        holder.roomTextView.text = lesson.room
    }

    override fun getItemCount(): Int {
        return lessons.size
    }
}
