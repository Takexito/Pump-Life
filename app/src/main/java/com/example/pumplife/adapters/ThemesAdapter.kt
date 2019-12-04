package com.example.pumplife.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pumplife.R
import com.example.pumplife.model.CourseThemes

class ThemesAdapter(private val themeList : MutableList<CourseThemes>): RecyclerView.Adapter<ThemesAdapter.ThemesHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThemesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.course_theme_item, parent, false)
        return ThemesHolder(view)
    }

    override fun getItemCount(): Int = themeList.size

    override fun onBindViewHolder(holder: ThemesHolder, position: Int) {
        val theme = themeList[position]
        holder.titleTextView.text = theme.title
    }

    inner class ThemesHolder(view: View): RecyclerView.ViewHolder(view) {

        val titleTextView = itemView.findViewById<TextView>(R.id.course_theme)

    }
}