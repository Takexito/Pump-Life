package com.example.pumplife.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pumplife.CourseActivity
import com.example.pumplife.R
import com.example.pumplife.controller.CourseManager
import kotlinx.android.synthetic.main.fragment_course_description.*

class CourseDescriptionFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_course_description, container, false)
        return  view
    }

    override fun onResume() {
        super.onResume()
        if(CourseManager.currCourse.completedCardNum > 0) start_button.text = "Продолжить"
        descriptionView.text = CourseManager.currCourse.description
        start_button.setOnClickListener{
            startActivity(Intent(context, CourseActivity::class.java))
        }
    }

}

