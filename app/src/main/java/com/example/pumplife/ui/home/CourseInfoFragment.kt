package com.example.pumplife.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.pumplife.R
import com.example.pumplife.adapters.InfoPagerAdapter
import com.example.pumplife.controller.CourseManager
import com.example.pumplife.model.Course
import kotlinx.android.synthetic.main.fragment_course_info.*

class CourseInfoFragment: Fragment() {

    lateinit var backButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_course_info, container, false)

//        backButton = view.findViewById(R.id.back_button)
//
//        backButton.setOnClickListener{
//            /*val tr = getFragmentManager()!!.beginTransaction()
//            tr.add(R.id.nav_host_fragment, HomeFragment()) */
//        }

        return  view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val infoPagerAdapter = InfoPagerAdapter(getChildFragmentManager())
        viewpager.adapter = infoPagerAdapter
        tabLayout.setupWithViewPager(viewpager)
        val text = CourseManager.currCourse.title
        titleView.text = text
        course_progressBar.progress = CourseManager.currCourse.percent()

    }
}