package com.example.pumplife.controller

import com.example.pumplife.model.*
import com.example.pumplife.ui.home.HomeFragment

object CourseManager {
    lateinit var coursesBlockList: ArrayList<CourseBlock>
    var completeList: ArrayList<Course> = arrayListOf()
    var startList: ArrayList<Course> = arrayListOf()
    lateinit var user: User
    lateinit var currCourse: Course
    var isFirst = true
    var context: HomeFragment? = null

    fun setCourseBlockList(list: ArrayList<CourseBlock>) {
        coursesBlockList = list
        currCourse = coursesBlockList[0].courseList[0]
    }

    fun clear(){
        completeList.clear()
        startList.clear()
    }

    fun checkUserData(course: Course) {
        user.userData.forEach {
            if (it.courseId == course.id) restoreData(course, it)
        }
    }

    private fun restoreData(course: Course, data: UserData) {
        course.completedCardNum = data.cardNum
        course.testComplete = data.isTest
        course.testCard.userAnswer = data.answer
        if (course.testComplete) completeList.add(course)
        else startList.add(course)
    }


    fun getCourseByIndex(theme: Themes, index: Int): Course? {
        return getCourseBlockByTheme(theme)?.courseList?.get(index)
    }

    fun getCourseById(id: Int): Course? {
        var course: Course? = null
        coursesBlockList.forEach {
            course = it.courseList.find { course -> course.id == id }
        }
        return course
    }

    fun getCourseBlockSize(theme: Themes): Int {
        return getCourseBlockByTheme(theme)?.courseList?.size ?: 0
    }

    fun getCourseBlockByTheme(theme: Themes): CourseBlock? {
        return coursesBlockList.find { block -> block.theme == theme }
    }

    fun updateAdapter() {
        if (context == null) return
        if (isFirst) {
            context!!.createAdapter()
        } else
            context!!.updateAdapter()
    }
}
