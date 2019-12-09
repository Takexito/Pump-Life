package com.example.pumplife.ui.fragment.mycourses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pumplife.R
import com.example.pumplife.adapters.PassedCoursesAdapter

class PassedCoursesFragment : Fragment() {

    lateinit var passedCoursesBlockRecyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_passed_courses, container, false)

        passedCoursesBlockRecyclerView = root.findViewById(R.id.passed_courses_recycler_view)

        setRecyclerViews()

        return root
    }

    private fun setRecyclerViews() {

        passedCoursesBlockRecyclerView.apply {
            layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
            adapter = PassedCoursesAdapter()
        }

    }

    override fun onResume() {
        super.onResume()
        setRecyclerViews()
    }
}