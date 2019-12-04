package com.example.pumplife.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.pumplife.R
import com.example.pumplife.adapters.InfoPagerAdapter
import kotlinx.android.synthetic.main.fragment_course_info.*

class CourseInfoFragment: DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_course_info, container, false)
        return  view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        val infoPagerAdapter = InfoPagerAdapter(getChildFragmentManager())
        viewpager.adapter = infoPagerAdapter
        tabLayout.setupWithViewPager(viewpager)
        super.onActivityCreated(savedInstanceState)
    }
}