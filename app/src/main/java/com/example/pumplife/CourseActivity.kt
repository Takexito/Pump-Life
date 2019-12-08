package com.example.pumplife

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pumplife.controller.CourseManager
import com.example.pumplife.model.TheorCard
import com.example.pumplife.ui.courses.TheorCardFragment
import kotlinx.android.synthetic.main.activity_course.*

class CourseActivity : AppCompatActivity() {

    val course = CourseManager.currCourse
    var card: TheorCard? = null
    var cardID = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)

        cardID = course.completedCardNum
        setCard()

//        closeButton.setOnClickListener{
//            close()
//        }
        progressBar.progress = course.percent()
    }


    fun next() {
        if (cardID++ >= course.cardList.size - 1){
            card = null
            course.completedCardNum++
        }
        else{
            card = course.cardList[cardID]
            if(cardID >= course.completedCardNum) course.completedCardNum++
        }
        progressBar.progress = course.percent()
        textView.text = card?.title
        supportFragmentManager.beginTransaction().replace(R.id.courseFragment, TheorCardFragment()).commit()
    }

//    fun prev(){
//        if (cardID <= 0) card = null
//        else card = course.cardList[cardID-1]
//        cardID -= 1
//
//        supportFragmentManager.beginTransaction().replace(R.id.courseFragment, TheorCardFragment()).commit()
//    }

    fun close() {
        super.finish()
    }

    fun setCard(){
        if(!course.isFullyCompleted()) {
            card = course.cardList[cardID]
            supportFragmentManager.beginTransaction().replace(R.id.courseFragment, TheorCardFragment()).commit()
        }
        else {
            card = null
            supportFragmentManager.beginTransaction().replace(R.id.courseFragment, TheorCardFragment()).commit()
        }
        textView.text = card?.title ?: "Конец"
    }
}
