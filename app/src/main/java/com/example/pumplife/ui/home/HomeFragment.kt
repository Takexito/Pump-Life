package com.example.pumplife.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pumplife.R
import com.example.pumplife.adapters.CoursesBlockAdapter
import com.example.pumplife.adapters.InfoPagerAdapter
import com.example.pumplife.adapters.ThemesAdapter
import com.example.pumplife.factories.CourseBlockDataFactory
import com.example.pumplife.factories.CourseThemeDataFactory
import kotlinx.android.synthetic.main.fragment_course_info.*

class HomeFragment : Fragment() {

     lateinit var coursesBlockRecyclerView: RecyclerView
     lateinit var coursesCardView: CardView
     lateinit var button: Button


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val view = inflater.inflate(R.layout.course_item, container, false)

        coursesBlockRecyclerView = root.findViewById(R.id.recyclerView_course_block)
        coursesCardView = view.findViewById(R.id.course_card_view)
        button = root.findViewById(R.id.button)

        setRecyclerViews()
        setOnClickListeners()

        return root
    }

    fun setRecyclerViews(){

        coursesBlockRecyclerView.apply {
            layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
            adapter =
                CoursesBlockAdapter(CourseBlockDataFactory.getCourseBlock())
        }

    }

    fun setOnClickListeners() {
        button.setOnClickListener{
            CourseInfoFragment().show(fragmentManager!!,"CourseInfoFragment")
        }

        coursesCardView.setOnClickListener{
            CourseInfoFragment().show(fragmentManager!!,"CourseInfoFragment")
        }
    }
}