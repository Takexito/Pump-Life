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

class ThemesAdapter : RecyclerView.Adapter<ThemesAdapter.ThemesHolder>() {

    private lateinit var context: Context
    private val themeList = CourseManager.getCourseBlockByTheme(CourseManager.currCourse.theme)?.courseList ?: arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThemesHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.course_theme_item, parent, false)
        context = parent.context
        return ThemesHolder(view)
    }

    override fun getItemCount(): Int = themeList.size

    override fun onBindViewHolder(holder: ThemesHolder, position: Int) {
        val course = themeList[position]
        holder.titleTextView.text = course.title
        holder.itemView.setOnClickListener{
            CourseManager.currCourse = course
            (context as MainActivity).navController.navigate(R.id.courseInfoFragment)
        }
    }

    inner class ThemesHolder(view: View) : RecyclerView.ViewHolder(view) {

        val titleTextView = itemView.findViewById<TextView>(R.id.course_theme)

    }
}