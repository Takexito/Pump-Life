package com.example.pumplife.factories

import com.example.pumplife.model.Card
import com.example.pumplife.model.Course
import com.example.pumplife.model.Themes
import com.example.pumplife.model.TheorCard

object CourseDataFactory {

    fun getCourse(): MutableList<Course> {
        val courseList = mutableListOf<Course>()
//        for (i in 0..10) {
//            val course = Course(i, "Title $i")
//            courseList.add(course)
//        }

        courseList.add(Course())
        return courseList
    }

}