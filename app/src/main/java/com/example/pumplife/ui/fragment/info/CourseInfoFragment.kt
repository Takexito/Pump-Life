package com.example.pumplife.ui.fragment.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pumplife.R
import com.example.pumplife.adapters.InfoPagerAdapter
import com.example.pumplife.controller.AppController
import com.example.pumplife.model.Themes
import kotlinx.android.synthetic.main.fragment_course_info.*

class CourseInfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_course_info, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val infoPagerAdapter = InfoPagerAdapter(childFragmentManager)
        viewpager.adapter = infoPagerAdapter
        tabLayout.setupWithViewPager(viewpager)
        val text = AppController.currCourse.title
        titleView.text = text
        course_progressBar.progress = AppController.currCourse.percent()
        setImage(AppController.currCourse.theme)
        activity!!.title = text

    }

    private fun setImage(theme: Themes) {
        if (theme == Themes.FINANCE) imageView2.setImageResource(R.drawable.fin)
        if (theme == Themes.LIFE) imageView2.setImageResource(R.drawable.life)
        if (theme == Themes.LEADER) imageView2.setImageResource(R.drawable.lid)

    }

    override fun onResume() {
        super.onResume()
        course_progressBar.progress = AppController.currCourse.percent()
        val text = AppController.currCourse.title
        titleView.text = text
        setImage(AppController.currCourse.theme)
        activity!!.title = text
    }
}