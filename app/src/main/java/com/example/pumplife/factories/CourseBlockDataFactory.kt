package com.example.pumplife.factories

import com.example.pumplife.model.CourseBlock
import com.example.pumplife.model.Themes

object CourseBlockDataFactory {

    fun getCourseBlock(): MutableList<CourseBlock> {
        val courseBlockList = mutableListOf<CourseBlock>()
        val courseList = CourseDataFactory.getCourse()
        //for (i in 0..10) {
            val courseBlock = CourseBlock(0, Themes.FINANCE, courseList)
            courseBlockList.add(courseBlock)
        //}
        return courseBlockList
    }
}