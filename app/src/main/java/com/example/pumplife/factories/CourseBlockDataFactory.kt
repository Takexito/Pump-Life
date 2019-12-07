package com.example.pumplife.factories

import com.example.pumplife.model.CourseBlock

object CourseBlockDataFactory {

    fun getCourseBlock(): MutableList<CourseBlock> {
        val courseBlockList = mutableListOf<CourseBlock>()
        val courseList = CourseDataFactory.getCourse()
        for (i in 0..2) {
            val CourseBlock = CourseBlock(i, "Title $i", courseList)
            courseBlockList.add(CourseBlock)
        }
        return courseBlockList
    }
}