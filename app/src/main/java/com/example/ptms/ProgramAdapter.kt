package com.example.ptms

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
//import org.gradle.kotlin.dsl.execution.Program




class ProgramAdapter(programList: ArrayList<Model>,listener: SelectListener) : RecyclerView.Adapter<single_row>() {
    var arrProgram = ArrayList<Model>()
    var listener:SelectListener
    init {
        arrProgram.addAll(programList)
        this.listener= listener
    }
    fun setFilteredList(arrProgram:ArrayList<Model>) {
        this.arrProgram = arrProgram
        notifyDataSetChanged()
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
        val progData = arrProgram.get(position)
        holder.programTitle.setText(progData.getTitle())
        holder.programImg.setImageResource(progData.getImage()!!)
        holder.progDesc.setText(progData.getDesc())
        val isExpandable : Boolean = progData.getIsExpandable()!!
        holder.progDesc.visibility = if(isExpandable) View.VISIBLE else View.GONE
        holder.relativeLayout.setOnClickListener{
            isAnyItemExpanded(position)
            progData.isExpandable = !progData.isExpandable!!
            listener.onItemClicked(arrProgram.get(position))
            notifyItemChanged(position)
        }

    }

    private fun isAnyItemExpanded(position: Int){
        val temp = arrProgram.indexOfFirst {
            it.isExpandable!!
        }
        if(temp>=0 && temp !=position){
            arrProgram[temp].isExpandable = false
            notifyItemChanged(temp ,Unit)
        }

    }

    override fun onBindViewHolder(holder: single_row, position: Int, payloads: MutableList<Any>) {
        if(payloads.isNotEmpty() && payloads[0] ==0){
            holder.collapseExpandadedView()
        }else{
            super.onBindViewHolder(holder, position, payloads)
        }

    }

}
