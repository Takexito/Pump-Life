package com.example.pumplife.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pumplife.R
import com.example.pumplife.model.CourseLab

class CoursesAdapter: RecyclerView.Adapter<CoursesAdapter.CoursesHolder>() {

    val courseList = CourseLab().courseList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.course_item, parent, false)
        return CoursesHolder(view)
    }

    override fun getItemCount(): Int = courseList.size

    override fun onBindViewHolder(holder: CoursesHolder, position: Int) {
        holder.bind(position)
    }

    inner class CoursesHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(position: Int) {}
    }
}