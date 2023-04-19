package com.example.ptms
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView

import androidx.recyclerview.widget.RecyclerView

class single_row(itemView: View) : RecyclerView.ViewHolder(itemView) {

     val programTitle: TextView = itemView.findViewById(R.id.header)
     val programImg: ImageView = itemView.findViewById(R.id.img1)
     val progDesc:TextView = itemView.findViewById(R.id.progDesc)
     val relativeLayout:RelativeLayout = itemView.findViewById(R.id.relativeLayout)
     val cardView:CardView = itemView.findViewById(R.id.cardView)
     fun collapseExpandadedView(){
          progDesc.visibility = View.GONE
     }

}