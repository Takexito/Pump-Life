package com.example.pumplife.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pumplife.R
import com.example.pumplife.model.CourseBlockLab

class CoursesBlockAdapter: RecyclerView.Adapter<CoursesBlockAdapter.CoursesBlockHolder>() {

    val courseBlockList = CourseBlockLab().courseBlockList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesBlockHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.course_block_item, parent, false)
        return CoursesBlockHolder(view)
    }

    override fun getItemCount(): Int = courseBlockList.size

    override fun onBindViewHolder(holder: CoursesBlockHolder, position: Int) {
        holder.bind(position)
    }

    inner class CoursesBlockHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(position: Int) {}
    }

}