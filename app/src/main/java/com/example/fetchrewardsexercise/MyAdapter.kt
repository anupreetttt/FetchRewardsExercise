package com.example.fetchrewardsexercise

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView


class MyAdapter(val context: Context, val uniqueIds: List<Int>, val dataItems: List<MyDataItem>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val listId: TextView = itemView.findViewById(R.id.list_id)
        val name: TextView = itemView.findViewById(R.id.textView1)
        val constraintLayout: ConstraintLayout = itemView.findViewById(R.id.expandedLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.row_items, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
        val currentItem = dataItems[position]

        val uniqueId = uniqueIds[position]
        val item = dataItems.find { it.listId == uniqueId }
        holder.listId.text = "List " + item?.listId.toString()
        holder.name.text = currentItem.name

        val isVisible : Boolean = currentItem.visibility
        holder.constraintLayout.visibility = if (isVisible) View.VISIBLE else View.GONE

        holder.itemView.setOnClickListener {
            if (item != null) {
                Toast.makeText(context, "Clicked item: ${item.listId}", Toast.LENGTH_SHORT).show()
            }

            currentItem.visibility = !currentItem.visibility
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int {
        return uniqueIds.size
    }
}


