package com.example.pumplife.ui.fragment.info

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pumplife.R
import com.example.pumplife.controller.AppController
import com.example.pumplife.controller.UsersDB
import com.example.pumplife.ui.activity.CourseActivity
import kotlinx.android.synthetic.main.fragment_course_description.*

class CourseDescriptionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_course_description, container, false)
    }

    override fun onResume() {
        super.onResume()
        if (AppController.currCourse.completedCardNum > 0) start_button.text = "Продолжить"
        if (AppController.currCourse.isFullyCompleted()) {
            start_button.text = "Пройти снова"
            start_button.setOnClickListener {
                val temp =
                    AppController.user.userData.find { it.courseId == AppController.currCourse.id }
                temp?.cardNum = 0
                UsersDB.saveUser()
                AppController.currCourse.completedCardNum = 0
                startActivity(Intent(context, CourseActivity::class.java))
            }
        } else start_button.setOnClickListener {
            startActivity(Intent(context, CourseActivity::class.java))
        }
        descriptionView.text = AppController.currCourse.description

    }

}

