package com.example.pumplife.ui.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pumplife.R
import com.example.pumplife.adapters.CoursesBlockAdapter
import com.example.pumplife.controller.AppController
import com.example.pumplife.controller.CoursesDB


class HomeFragment : Fragment() {

    lateinit var coursesBlockRecyclerView: RecyclerView
    lateinit var coursesCardView: CardView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val view = inflater.inflate(R.layout.course_item, container, false)

        coursesBlockRecyclerView = root.findViewById(R.id.recyclerView_course_block)
        coursesCardView = view.findViewById(R.id.course_card_view)

        CoursesDB.init()
        AppController.context = this
        return root
    }

    fun createAdapter() {
        AppController.clear()
        coursesBlockRecyclerView.apply {
            layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
            adapter = CoursesBlockAdapter()
        }

    }
}