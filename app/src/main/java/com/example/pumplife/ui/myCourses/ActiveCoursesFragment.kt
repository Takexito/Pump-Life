package com.example.pumplife.ui.myCourses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pumplife.R
import com.example.pumplife.adapters.MyCoursesAdapter
import com.example.pumplife.controller.CourseManager

class ActiveCoursesFragment: Fragment() {

    lateinit var activeCoursesBlockRecyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_active_courses, container, false)

        activeCoursesBlockRecyclerView = root.findViewById(R.id.active_courses_recycler_view)

        setRecyclerViews()

        return root
    }

    fun setRecyclerViews(){
        activeCoursesBlockRecyclerView.apply {
            layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
            adapter = MyCoursesAdapter()
        }

    }

    override fun onResume() {
        super.onResume()
        setRecyclerViews()
    }
}