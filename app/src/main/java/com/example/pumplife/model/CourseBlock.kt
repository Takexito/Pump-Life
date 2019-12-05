package com.example.pumplife.model

class CourseBlock(
    val id: Int = 0,
    val theme: Themes = Themes.FINANCE,
    val courseList: MutableList<Course> = arrayListOf()
)