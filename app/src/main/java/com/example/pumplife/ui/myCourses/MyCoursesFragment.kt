package com.example.pumplife.ui.myCourses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pumplife.R
import com.example.pumplife.adapters.MyCoursesPagerAdapter
import kotlinx.android.synthetic.main.fragment_my_courses.*

class MyCoursesFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_my_courses, container, false)

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        val infoPagerAdapter = MyCoursesPagerAdapter(getChildFragmentManager())
        viewpager2.adapter = infoPagerAdapter
        tabLayout2.setupWithViewPager(viewpager2)
        super.onActivityCreated(savedInstanceState)
    }
}