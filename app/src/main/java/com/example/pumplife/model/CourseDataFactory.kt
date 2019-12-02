package com.example.pumplife.model

object CourseDataFactory {

    fun getCourse(): MutableList<Course> {
        val courseList = mutableListOf<Course>()
        for (i in 0..10) {
            val course = Course(i,"Title $i")
            courseList.add(course)
        }
        return courseList
    }

}