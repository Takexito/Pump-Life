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
import com.example.pumplife.controller.DataBase
import com.example.pumplife.factories.CourseBlockDataFactory
import com.example.pumplife.model.CourseBlock
import com.example.pumplife.model.Themes

class HomeFragment : Fragment() {

     lateinit var coursesBlockRecyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        coursesBlockRecyclerView = root.findViewById(R.id.recyclerView_course_block)
        //CoursesBlockAdapter(CourseBlockDataFactory.getCourseBlock() as ArrayList<CourseBlock>)
        DataBase.init(this)


        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    fun updateAdapter(){
        coursesBlockRecyclerView.adapter!!.notifyDataSetChanged()
    }
    fun createAdapter(){
        coursesBlockRecyclerView.apply {
            layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
            adapter = CoursesBlockAdapter(arrayListOf(CourseBlock(0, Themes.FINANCE, DataBase.data)))
        }
    }
}