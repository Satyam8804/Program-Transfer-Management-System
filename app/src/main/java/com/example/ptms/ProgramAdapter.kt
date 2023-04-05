package com.example.ptms

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
//import org.gradle.kotlin.dsl.execution.Program




class ProgramAdapter(programList: ArrayList<Model>) : RecyclerView.Adapter<single_row>() {
    var arrProgram = ArrayList<Model>()

    init {
        arrProgram.addAll(programList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): single_row {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.activity_single_row, parent, false)
        return single_row(view)
    }

    override fun getItemCount(): Int {
        return arrProgram.size
    }

    override fun onBindViewHolder(holder: single_row, position: Int) {
        holder.programTitle.setText(arrProgram.get(position).getTitle())
        holder.programImg.setImageResource(arrProgram.get(position).getImage()!!)
    }

}
