package com.example.pumplife.factories

import com.example.pumplife.model.Course

object CourseDataFactory {

    fun getCourse(): MutableList<Course> {
        val courseList = mutableListOf<Course>()
        for (i in 0..10) {
            val course = Course(i, "Title $i")
            courseList.add(course)
        }
        return courseList
    }

}