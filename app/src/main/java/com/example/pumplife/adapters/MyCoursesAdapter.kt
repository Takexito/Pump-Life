package com.example.pumplife.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pumplife.MainActivity
import com.example.pumplife.R
import com.example.pumplife.controller.CourseManager

class MyCoursesAdapter : RecyclerView.Adapter<MyCoursesAdapter.CoursesHolder>() {

    lateinit var contexxt: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.course_item, parent, false)
        contexxt = parent.context

        return CoursesHolder(view)
    }

    override fun getItemCount(): Int = CourseManager.startList.size


    private fun bind(holder: CoursesHolder, position: Int) {
        val course = CourseManager.startList[position]
        holder.titleTextView.text = course.title
        holder.itemView.setOnClickListener {
            CourseManager.currCourse = course
            (contexxt as MainActivity).navController.navigate(R.id.courseInfoFragment)
        }
    }

    inner class CoursesHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView = itemView.findViewById<TextView>(R.id.course_name)
    }

    override fun onBindViewHolder(holder: CoursesHolder, position: Int) {
        bind(holder, position)
    }
}