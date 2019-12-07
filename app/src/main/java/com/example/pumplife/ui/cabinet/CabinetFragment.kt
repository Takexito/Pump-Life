package com.example.pumplife.ui.cabinet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.pumplife.R
import kotlinx.android.synthetic.main.fragment_cabinet.view.*

class CabinetFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cabinet, container, false)

        view.change_avatar_button.setOnClickListener{
            Toast.makeText(activity, "Change avatar", Toast.LENGTH_LONG).show()
        }

        view.change_password_button.setOnClickListener{
            Toast.makeText(activity, "Change password", Toast.LENGTH_LONG).show()
        }

        view.change_user_button.setOnClickListener{
            Toast.makeText(activity, "Change user", Toast.LENGTH_LONG).show()

        }

        return view
    }

}