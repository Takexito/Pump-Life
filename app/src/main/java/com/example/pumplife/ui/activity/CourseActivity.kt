package com.example.pumplife.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pumplife.R
import com.example.pumplife.controller.AppController
import com.example.pumplife.model.TheoryCard
import com.example.pumplife.ui.fragment.cards.TheorCardFragment
import kotlinx.android.synthetic.main.activity_course.*

class CourseActivity : AppCompatActivity() {

    val course = AppController.currCourse
    var card: TheoryCard? = null
    var cardID = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)

        cardID = course.completedCardNum
        setCard()

        progressBar.progress = course.percent()
    }

    fun next() {
        if (cardID++ >= course.cardList.size - 1) {
            card = null
            course.completedCardNum++
        } else {
            card = course.cardList[cardID]
            if (cardID >= course.completedCardNum) course.completedCardNum++
        }
        progressBar.progress = course.percent()
        textView.text = card?.title
        supportFragmentManager.beginTransaction().replace(R.id.courseFragment, TheorCardFragment())
            .commit()
    }

    fun close() {
        super.finish()
    }

    private fun setCard() {
        if (!course.isFullyCompleted()) {
            card = course.cardList[cardID]
            supportFragmentManager.beginTransaction()
                .replace(R.id.courseFragment, TheorCardFragment()).commit()
        } else {
            card = null
            supportFragmentManager.beginTransaction()
                .replace(R.id.courseFragment, TheorCardFragment()).commit()
        }
        textView.text = card?.title ?: "Конец"
    }
}
