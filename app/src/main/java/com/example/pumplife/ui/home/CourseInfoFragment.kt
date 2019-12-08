package com.example.pumplife.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pumplife.R
import com.example.pumplife.adapters.InfoPagerAdapter
import com.example.pumplife.controller.CourseManager
import kotlinx.android.synthetic.main.fragment_course_info.*

class CourseInfoFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_course_info, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val infoPagerAdapter = InfoPagerAdapter(childFragmentManager)
        viewpager.adapter = infoPagerAdapter
        tabLayout.setupWithViewPager(viewpager)
        val text = CourseManager.currCourse.title
        titleView.text = text
        course_progressBar.progress = CourseManager.currCourse.percent()

        activity!!.title = text

    }

    override fun onResume() {
        super.onResume()
        course_progressBar.progress = CourseManager.currCourse.percent()
    }
}