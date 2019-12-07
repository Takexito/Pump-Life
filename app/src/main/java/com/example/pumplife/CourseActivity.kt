package com.example.pumplife

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pumplife.controller.CourseManager
import com.example.pumplife.model.Card
import com.example.pumplife.model.Course
import com.example.pumplife.model.TheorCard
import com.example.pumplife.ui.courses.TheorCardFragment
import kotlinx.android.synthetic.main.activity_course.*

class CourseActivity : AppCompatActivity() {

    val course = CourseManager.currCourse
    var card: TheorCard? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)
        if(!course.isFullyCompleted()) {
            next()
            card = course.cardList[course.completedCardNum - 1]
        }
        else {
            next()
            card = null
        }
    }

    fun next() {
        card = course.nextCard() as TheorCard?
        supportFragmentManager.beginTransaction().replace(R.id.courseFragment, TheorCardFragment()).addToBackStack(null).commit()
    }

    fun close() {
        super.finish()
    }
}
