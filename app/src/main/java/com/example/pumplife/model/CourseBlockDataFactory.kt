package com.example.pumplife.model

object CourseBlockDataFactory {

    fun getCourseBlock(): MutableList<CourseBlock> {
        val courseBlockList = mutableListOf<CourseBlock>()
        val courseList = CourseDataFactory.getCourse()
        for (i in 0..10) {
            val CourseBlock = CourseBlock(i ,"Title $i", courseList)
            courseBlockList.add(CourseBlock)
        }
        return courseBlockList
    }
}