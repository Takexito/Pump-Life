package com.example.pumplife.controller

import android.util.Log
import androidx.fragment.app.Fragment
import com.example.pumplife.model.Course
import com.example.pumplife.ui.home.HomeFragment
import com.google.firebase.database.*


object DataBase {
    val database = FirebaseDatabase.getInstance()
    val myRef = database.getReference("Courses")
    var data = arrayListOf<Course>()
    lateinit var postListener: ValueEventListener
    var isFirst = true

    fun init(adapter: Fragment) {
        postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                //Get Post object and use the values to update the UI
                val genericTypeIndicator: GenericTypeIndicator<HashMap<String, Course>> =
                    object :
                        GenericTypeIndicator<HashMap<String, Course>>() {}
                val map =
                    dataSnapshot.getValue(genericTypeIndicator)
                val list = map!!.values.toList()
                data = ArrayList(list)
                Log.d("database", "msg: ")
                if(isFirst)(adapter as HomeFragment).createAdapter()
                else (adapter as HomeFragment).updateAdapter()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w("database", "loadPost:onCancelled", databaseError.toException())
                // ...
            }
        }
        myRef.addValueEventListener(postListener)

    }

    fun sendToDb(message: Course) {
        myRef.push().setValue(message)
    }

}
