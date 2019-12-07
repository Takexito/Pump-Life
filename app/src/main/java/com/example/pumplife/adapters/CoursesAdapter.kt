package com.example.pumplife.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pumplife.R
import com.example.pumplife.model.Course

class CoursesAdapter(private val courseList : MutableList<Course>): RecyclerView.Adapter<CoursesAdapter.CoursesHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.course_item, parent, false)

        return CoursesHolder(view)
    }

    override fun getItemCount(): Int = courseList.size

    override fun onBindViewHolder(holder: CoursesHolder, position: Int) {
        val course = courseList[position]
        holder.titleTextView.text = course.title
        holder.itemView.setOnClickListener{
            //DataBase.sendToDb(course)
        }

    }

    inner class CoursesHolder(view: View): RecyclerView.ViewHolder(view){
        val titleTextView = itemView.findViewById<TextView>(R.id.course_name)
    }
}

