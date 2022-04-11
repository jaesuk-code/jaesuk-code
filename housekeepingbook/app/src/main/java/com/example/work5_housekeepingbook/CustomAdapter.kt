package com.example.work5_housekeepingbook

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CustomAdapter(private  val context: Context, private val list: MutableList<List>)
    :RecyclerView.Adapter<CustomAdapter.ItemViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.view_item_layout,parent,false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(list[position],context)
    }


    override fun getItemCount(): Int {
        return list.size
    }

    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        private val usage = itemView.findViewById<TextView>(R.id.usageTxt)
        private val cost = itemView.findViewById<TextView>(R.id.costTxt)
        private val date = itemView.findViewById<TextView>(R.id.dateTxt2)
        private val memo = itemView.findViewById<TextView>(R.id.memoTxt2)

        fun bind(list: List, context: Context){
            usage.text = List.usage
            cost.text = List.price.toString()
            date.text = List.date
            memo.text = List.memo

        }
    }

}