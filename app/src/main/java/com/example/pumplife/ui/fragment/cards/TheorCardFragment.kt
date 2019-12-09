package com.example.pumplife.ui.fragment.cards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pumplife.R
import com.example.pumplife.controller.AppController
import com.example.pumplife.controller.UsersDB
import com.example.pumplife.ui.activity.CourseActivity
import kotlinx.android.synthetic.main.fragment_theor_card.*

class TheorCardFragment : Fragment() {

    lateinit var activity: CourseActivity
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_theor_card, container, false)
        activity = context as CourseActivity
        AppController.saveUserData(activity.course, activity.course.completedCardNum)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity.card == null) {
            theorTextView.text = "Вы прошли курс!"
            theorNextButton.text = "Закончить"
            theorNextButton.setOnClickListener {
                UsersDB.saveUser()
                activity.close()
            }
        } else {
            theorTextView.text = activity.card?.body ?: "Вы прошли курс!"
            theorNextButton.setOnClickListener {
                UsersDB.saveUser()
                activity.next()
            }
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity.title = activity.card?.title ?: "Конец"
    }
}