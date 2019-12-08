package com.example.pumplife.controller

import android.util.Log
import com.example.pumplife.model.*
import com.example.pumplife.ui.home.HomeFragment

object CourseManager {
    lateinit var coursesBlockList: ArrayList<CourseBlock>
    var completeList: ArrayList<Course> = arrayListOf()
    var startList: ArrayList<Course> = arrayListOf()
    lateinit var user: User
    lateinit var currCourse: Course
    var context: HomeFragment? = null

    fun setCourseBlockList(list: ArrayList<CourseBlock>) {
        coursesBlockList = list
        currCourse = coursesBlockList[0].courseList[0]
    }

    fun clear(){
        completeList.clear()
        startList.clear()
    }

    fun saveUserData(course: Course, num: Int, isTest: Boolean = false){
        val us = user.userData.find{ it.courseId == course.id }
        if(us == null) user.userData.add(UserData(course.id, num, isTest))
        else {
            us.cardNum = num
        }
        Log.d("User", "save to user and course $num")
        course.completedCardNum = num
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
        listCreate(course)
    }

    fun check(){
        coursesBlockList.forEach {block ->
            block.courseList.forEach{
                checkUserData(it)
            }
        }
    }

    fun listCreate(course: Course){
        if (course.isFullyCompleted()) completeList.add(course)
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
            context!!.createAdapter()

    }
}
