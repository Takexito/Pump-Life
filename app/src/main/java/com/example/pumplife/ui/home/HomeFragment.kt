package com.example.pumplife.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pumplife.R
import com.example.pumplife.adapters.CoursesBlockAdapter
import com.example.pumplife.factories.CourseBlockDataFactory

class HomeFragment : Fragment() {

     lateinit var coursesBlockRecyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)

       coursesBlockRecyclerView = root.findViewById(R.id.recyclerView_course_block)

        coursesBlockRecyclerView.apply {
            layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
            adapter =
                CoursesBlockAdapter(CourseBlockDataFactory.getCourseBlock())
        }

        return root
    }
}