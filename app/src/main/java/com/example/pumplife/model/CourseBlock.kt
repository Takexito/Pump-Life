package com.example.pumplife.model

class CourseBlock(
    val id: Int,
    val title: String,
    val courseList: MutableList<Course>
)

/*class CourseBlockLab {

    val courseBlockList: MutableList<CourseBlock>

    val courseList = CourseLab().courseList

    init {
        courseBlockList = mutableListOf()
        for (i in 0..10) {
            val CourseBlock = CourseBlock(i,"Title $i", courseList)
            courseBlockList.add(CourseBlock)
        }
    }
} */