package com.example.pumplife.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pumplife.R
import com.example.pumplife.adapters.CoursesBlockAdapter

import com.example.pumplife.adapters.InfoPagerAdapter
import com.example.pumplife.adapters.ThemesAdapter
import com.example.pumplife.factories.CourseBlockDataFactory
import com.example.pumplife.factories.CourseThemeDataFactory
import kotlinx.android.synthetic.main.fragment_course_info.*

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

        setRecyclerViews()
        setOnClickListeners()

        return root
    }

    fun setRecyclerViews(){
        coursesBlockRecyclerView = root.findViewById(R.id.recyclerView_course_block)
        //CoursesBlockAdapter(CourseBlockDataFactory.getCourseBlock() as ArrayList<CourseBlock>)
        CoursesDB.init(this)

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
            adapter = //CoursesBlockAdapter(arrayListOf(CourseBlock(0, Themes.FINANCE, DataBase.data)))
            CoursesBlockAdapter(CoursesDB.data)
        }

    }

    fun setOnClickListeners() {
    }
}