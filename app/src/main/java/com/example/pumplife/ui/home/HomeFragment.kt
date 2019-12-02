package com.example.pumplife.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pumplife.R
import com.example.pumplife.model.CourseBlockDataFactory

class HomeFragment : Fragment() {

     lateinit var coursesBlockRecyclerView: RecyclerView
    //private lateinit var coursesRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)

       coursesBlockRecyclerView = root.findViewById(R.id.recyclerView_course_block)

        coursesBlockRecyclerView.apply {
            layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
            adapter = CoursesBlockAdapter(CourseBlockDataFactory.getCourseBlock())
        }


       /* coursesBlockRecyclerView.layoutManager = LinearLayoutManager(container!!.context)
        coursesBlockRecyclerView.adapter = CoursesBlockAdapter()

        coursesRecyclerView = root.findViewById(R.id.recyclerView_course)
        coursesRecyclerView.layoutManager = LinearLayoutManager(container!!.context)
        coursesRecyclerView.adapter = CoursesAdapter()
        coursesRecyclerView.layoutManager = LinearLayoutManager(this.context) // horizontal orientation
        coursesRecyclerView.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL ,false) // horizontal orientation */

        return root
    }
}