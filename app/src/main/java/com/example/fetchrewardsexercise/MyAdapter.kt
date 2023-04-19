package com.example.fetchrewardsexercise

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class MyAdapter(val context: Context, val uniqueIds: List<Int>, val dataItems: List<MyDataItem>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val listId: TextView = itemView.findViewById(R.id.list_id)
//        val listName: TextView = itemView.findViewById(R.id.list_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.row_items, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
        val uniqueId = uniqueIds[position]
        val item = dataItems.find { it.listId == uniqueId }
        holder.listId.text = "List " + item?.listId.toString()
//        holder.listName.text = "List "

        holder.itemView.setOnClickListener {
            Toast.makeText(context, "Clicked item: ${item?.listId}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return uniqueIds.size
    }
}


