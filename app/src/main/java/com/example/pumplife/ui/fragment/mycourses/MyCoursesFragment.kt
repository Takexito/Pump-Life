package com.example.pumplife.ui.fragment.mycourses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pumplife.R
import com.example.pumplife.adapters.MyCoursesPagerAdapter
import com.example.pumplife.controller.AppController
import kotlinx.android.synthetic.main.fragment_my_courses.*

class MyCoursesFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_my_courses, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val infoPagerAdapter = MyCoursesPagerAdapter(childFragmentManager)
        viewpager2.adapter = infoPagerAdapter
        tabLayout2.setupWithViewPager(viewpager2)
        AppController.clear()
        AppController.check()

    }

    override fun onResume() {
        super.onResume()
        AppController.clear()
        AppController.check()
    }


}