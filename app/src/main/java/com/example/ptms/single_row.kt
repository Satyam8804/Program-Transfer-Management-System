package com.example.ptms
import android.view.View
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

class single_row(itemView: View) : RecyclerView.ViewHolder(itemView) {

     val programTitle: TextView = itemView.findViewById(R.id.header)
     val programImg: ImageView = itemView.findViewById(R.id.img1)

}