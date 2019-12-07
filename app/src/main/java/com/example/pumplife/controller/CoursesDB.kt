package com.example.pumplife.controller

import android.util.Log
import com.example.pumplife.model.CourseBlock
import com.example.pumplife.ui.home.HomeFragment
import com.google.firebase.database.*


object CoursesDB {
    val database = FirebaseDatabase.getInstance()
    val myRef = database.getReference("Courses").child("-LvMPd1JOBCekMNr9xto")
    var data = arrayListOf<CourseBlock>()
    lateinit var postListener: ValueEventListener

    fun init(context: HomeFragment) {
        postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                update(dataSnapshot, context)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w("database", "loadPost:onCancelled", databaseError.toException())
            }
        }
        myRef.addValueEventListener(postListener)
    }

    fun update(dataSnapshot: DataSnapshot, context: HomeFragment){
        //Get Post object and use the values to update the UI
        val genericTypeIndicator: GenericTypeIndicator<ArrayList<CourseBlock>> =
            object :
                GenericTypeIndicator<ArrayList<CourseBlock>>() {}
        data = dataSnapshot.getValue(genericTypeIndicator)!!
        CourseManager.setCourseBlockList(data)
        CourseManager.updateAdapter()
    }


}
