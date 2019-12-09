package com.example.pumplife.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pumplife.R
import com.example.pumplife.controller.AppController
import com.example.pumplife.model.Themes
import com.example.pumplife.ui.activity.MainActivity
import kotlinx.android.synthetic.main.course_item.view.*

class PassedCoursesAdapter : RecyclerView.Adapter<PassedCoursesAdapter.CoursesHolder>() {

    lateinit var contexxt: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.course_item, parent, false)
        contexxt = parent.context

        return CoursesHolder(view)
    }

    override fun getItemCount(): Int = AppController.completeList.size


    private fun bind(holder: CoursesHolder, position: Int) {
        val course = AppController.completeList[position]
        holder.titleTextView.text = course.title
        setImage(course.theme, holder)
        holder.itemView.setOnClickListener {
            AppController.currCourse = course
            (contexxt as MainActivity).navController.navigate(R.id.courseInfoFragment)
        }
    }

    inner class CoursesHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView = itemView.findViewById<TextView>(R.id.course_name)
    }

    override fun onBindViewHolder(holder: CoursesHolder, position: Int) {
        bind(holder, position)
    }

    private fun setImage(theme: Themes, holder: CoursesHolder) {
        if (theme == Themes.FINANCE) holder.itemView.imageView.setImageResource(R.drawable.fin)
        if (theme == Themes.LIFE) holder.itemView.imageView.setImageResource(R.drawable.life)
        if (theme == Themes.LEADER) holder.itemView.imageView.setImageResource(R.drawable.lid)

    }
}