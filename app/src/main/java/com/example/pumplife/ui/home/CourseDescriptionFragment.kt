package com.example.pumplife.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pumplife.R
import com.example.pumplife.adapters.InfoPagerAdapter
import com.example.pumplife.adapters.ThemesAdapter
import com.example.pumplife.controller.CourseManager
import com.example.pumplife.factories.CourseThemeDataFactory
import kotlinx.android.synthetic.main.fragment_course_description.*
import kotlinx.android.synthetic.main.fragment_course_info.*

class CourseDescriptionFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_course_description, container, false)
        return  view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        descriptionView.text = CourseManager.currCourse.description
    }

}

