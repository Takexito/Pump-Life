package com.example.pumplife.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.pumplife.model.Course
import com.example.pumplife.ui.dashboard.DashboardFragment
import com.example.pumplife.ui.home.CourseDescriptionFragment
import com.example.pumplife.ui.home.CourseInfoFragment
import com.example.pumplife.ui.home.ThemeListFragment
import com.example.pumplife.ui.notifications.NotificationsFragment

class InfoPagerAdapter(manager: FragmentManager): FragmentPagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {

        return when (position) {
            0 -> {CourseDescriptionFragment()}
           else -> {ThemeListFragment()}
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {

        return when (position) {
            0 -> "О курсе"
            else -> "Модули"
        }
    }
}