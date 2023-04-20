package com.example.fetchrewardsexercise.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchrewardsexercise.DataModel.MyDataItem
import com.example.fetchrewardsexercise.R


class MyAdapter(val context: Context, val dataItems: List<Pair<Int, List<MyDataItem>>>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    // define ViewHolder class
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // define references to views in row_items.xml layout
        val listId: TextView = itemView.findViewById(R.id.list_id)
        val names: TextView = itemView.findViewById(R.id.textView1)
        val ids: TextView = itemView.findViewById(R.id.textView2)
        val linearLayout: LinearLayout = itemView.findViewById(R.id.expandedLayout)
    }

    // create ViewHolder instances
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflate row_items.xml layout and create ViewHolder instance
        val itemView = LayoutInflater.from(context).inflate(R.layout.row_items, parent, false)
        return ViewHolder(itemView)
    }

    // bind data to ViewHolder views
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // get the list ID for this ViewHolder
        val listId = dataItems[position].second[0]

        // set the list ID text for this ViewHolder
        holder.listId.text = "List ${listId.listId}"

        // join the names of all MyDataItems in this list and set the names text for this ViewHolder
        val names = dataItems[position].second.joinToString(" ") { "Name: ${it.name!!}" }
        holder.names.text = names

        // join the IDs of all MyDataItems in this list and set the IDs text for this ViewHolder
        val ids = dataItems[position].second.joinToString("  ") { " ID: ${it.id}" }
        holder.ids.text = ids

        // get the visibility of the linear layout and set it accordingly
        val isVisible : Boolean = listId.visibility
        holder.linearLayout.visibility = if (isVisible) View.VISIBLE else View.GONE

        // set click listener for the ViewHolder's item view
        holder.itemView.setOnClickListener {
            // display a toast with the clicked item's list ID
            Toast.makeText(context, "Showing list ID: ${listId.listId}", Toast.LENGTH_SHORT).show()

            // toggle the visibility of the linear layout and notify the adapter that data has changed
            listId.visibility = !listId.visibility
            notifyItemChanged(position)
        }
    }

    // return the number of items in the data set
    override fun getItemCount(): Int {
        return dataItems.size
    }
}

