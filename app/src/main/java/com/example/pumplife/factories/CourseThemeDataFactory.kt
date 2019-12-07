package com.example.pumplife.factories


import com.example.pumplife.model.CourseThemes
import com.example.pumplife.model.Themes


object CourseThemeDataFactory {

    fun getThemes(): MutableList<CourseThemes> {
        val themesList = mutableListOf<CourseThemes>()
        for (i in 0..10) {
            val theme = CourseThemes("$i")
            themesList.add(theme)
        }
        return themesList
    }
}