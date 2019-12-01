package com.example.pumplife.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pumplife.R

class HomeFragment : Fragment() {

    private lateinit var coursesBlockRecyclerView: RecyclerView
    private lateinit var coursesRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        coursesBlockRecyclerView = root.findViewById(R.id.recyclerView_course)
        coursesBlockRecyclerView.layoutManager = LinearLayoutManager(container!!.context)
        coursesBlockRecyclerView.adapter = CoursesAdapter()

        coursesRecyclerView = root.findViewById(R.id.recyclerView_course)
        coursesRecyclerView.layoutManager = LinearLayoutManager(container!!.context)
        coursesRecyclerView.adapter = CoursesBlockAdapter()

        return root
    }
}