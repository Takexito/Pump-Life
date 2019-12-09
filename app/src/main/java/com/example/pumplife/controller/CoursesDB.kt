package com.example.pumplife.controller

import android.util.Log
import com.example.pumplife.model.CourseBlock
import com.google.firebase.database.*


object CoursesDB {
    private val database = FirebaseDatabase.getInstance()
    private val myRef = database.getReference("Courses").child("-LvMPd1JOBCekMNr9xto")
    var data = arrayListOf<CourseBlock>()
    lateinit var postListener: ValueEventListener

    fun init() {
        postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                update(dataSnapshot)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w("database", "loadPost:onCancelled", databaseError.toException())
            }
        }
        myRef.addValueEventListener(postListener)
    }

    fun update(dataSnapshot: DataSnapshot) {
        val genericTypeIndicator: GenericTypeIndicator<ArrayList<CourseBlock>> =
            object :
                GenericTypeIndicator<ArrayList<CourseBlock>>() {}
        data = dataSnapshot.getValue(genericTypeIndicator)!!
        AppController.setCourseBlockList(data)
        AppController.updateAdapter()
    }


}
