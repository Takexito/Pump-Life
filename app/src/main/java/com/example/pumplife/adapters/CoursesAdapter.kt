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
import com.example.pumplife.model.Course
import com.example.pumplife.model.Themes
import kotlinx.android.synthetic.main.course_item.view.*

class CoursesAdapter(var theme: Themes): RecyclerView.Adapter<CoursesAdapter.CoursesHolder>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.course_item, parent, false)
        context = parent.context

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
        setImage(holder)
        holder.itemView.setOnClickListener{
            CourseManager.currCourse = course
            (context as MainActivity).navController.navigate(R.id.action_navigation_home_to_courseInfoFragment)//, Bundle(1).putString("title", course.title) )
        }
    }

    inner class CoursesHolder(view: View): RecyclerView.ViewHolder(view){
        val titleTextView = itemView.findViewById<TextView>(R.id.course_name)
    }

    private fun setImage(holder: CoursesHolder){
        if(theme == Themes.FINANCE) holder.itemView.imageView.setImageResource(R.drawable.fin)
        if(theme == Themes.LIFE) holder.itemView.imageView.setImageResource(R.drawable.life)
        if(theme == Themes.LIDER) holder.itemView.imageView.setImageResource(R.drawable.lid)

    }
}

