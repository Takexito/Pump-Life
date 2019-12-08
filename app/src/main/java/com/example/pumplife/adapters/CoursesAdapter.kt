package com.example.pumplife.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pumplife.MainActivity
import com.example.pumplife.R
import com.example.pumplife.controller.CourseManager
import com.example.pumplife.model.Course
import com.example.pumplife.model.Themes
import com.example.pumplife.ui.home.CourseInfoFragment
import com.example.pumplife.ui.home.HomeFragment

class CoursesAdapter(var theme: Themes): RecyclerView.Adapter<CoursesAdapter.CoursesHolder>() {

    lateinit var contexxt: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.course_item, parent, false)
        contexxt = parent.context

        return CoursesHolder(view)
    }

    override fun getItemCount(): Int = CourseManager.getCourseBlockSize(theme)

    override fun onBindViewHolder(holder: CoursesHolder, position: Int) {
        bind(holder, position)
    }

    private fun bind(holder: CoursesHolder, position: Int){
        val course = CourseManager.getCourseByIndex(theme, position) ?: Course() //courseList[position]
        CourseManager.checkUserData(course)
        CourseManager.listCreate(course)
        holder.titleTextView.text = course.title
        holder.itemView.setOnClickListener{
            CourseManager.currCourse = course
            (contexxt as MainActivity).navController.navigate(R.id.courseInfoFragment)
        }
    }

    inner class CoursesHolder(view: View): RecyclerView.ViewHolder(view){
        val titleTextView = itemView.findViewById<TextView>(R.id.course_name)
    }
}

