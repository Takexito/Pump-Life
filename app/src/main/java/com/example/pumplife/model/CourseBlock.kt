package com.example.pumplife.model

class CourseBlock(
    val id: Int,
    val title: String,
    val course: Course
)

class CourseBlockLab() {
    val courseBlockList: MutableList<Course>

    init {
        courseBlockList = mutableListOf()
        for (i in 0..10) {
        }
    }
}