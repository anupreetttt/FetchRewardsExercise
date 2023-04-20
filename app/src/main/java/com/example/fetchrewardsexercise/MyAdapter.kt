package com.example.fetchrewardsexercise

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView


class MyAdapter(val context: Context, val dataItems: List<Pair<Int, List<MyDataItem>>>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val listId: TextView = itemView.findViewById(R.id.list_id)
        val names: TextView = itemView.findViewById(R.id.textView1)
        val constraintLayout: LinearLayout = itemView.findViewById(R.id.expandedLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.row_items, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
        val currentItem = dataItems[position].second[0]

        holder.listId.text = "List " + currentItem.listId.toString()

        val names = dataItems[position].second.map { "Name: ${it.name!!}" }.joinToString(", ")
        holder.names.text = names

        val isVisible : Boolean = currentItem.visibility
        holder.constraintLayout.visibility = if (isVisible) View.VISIBLE else View.GONE

        holder.itemView.setOnClickListener {
            Toast.makeText(context, "Clicked item: ${currentItem.listId}", Toast.LENGTH_SHORT).show()

            currentItem.visibility = !currentItem.visibility
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int {
        return dataItems.size
    }
}
