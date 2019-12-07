package com.example.pumplife.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pumplife.R
import com.example.pumplife.model.CourseBlock


class CoursesBlockAdapter(private val courseBlockList : ArrayList<CourseBlock>): RecyclerView.Adapter<CoursesBlockAdapter.CoursesBlockHolder>() {

    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesBlockHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.course_block_item, parent, false)
        return CoursesBlockHolder(view)
    }

    override fun getItemCount(): Int = courseBlockList.size

    override fun onBindViewHolder(holder: CoursesBlockHolder, position: Int) {
        val courseBlock = courseBlockList[position]
        holder.courseBlockTitleTextView.text = courseBlock.theme.name
        holder.courseView.apply {
            layoutManager =
                LinearLayoutManager(holder.courseView.context, RecyclerView.HORIZONTAL, false)
            adapter = CoursesAdapter(courseBlock.courseList)
            setRecycledViewPool(viewPool)


        }
    }


    inner class CoursesBlockHolder(view: View): RecyclerView.ViewHolder(view){

        val courseBlockTitleTextView = itemView.findViewById<TextView>(R.id.course_block_title)
        val courseView: RecyclerView = itemView.findViewById(R.id.recyclerView_course)

    }

}