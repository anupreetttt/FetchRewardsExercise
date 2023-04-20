package com.anupreetttt.fetchrewardsexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.anupreetttt.fetchrewardsexercise.Adapter.MyAdapter
import com.example.fetchrewardsexercise.databinding.ActivityMainBinding
import com.anupreetttt.fetchrewardsexercise.viewModel.MyViewModel


// This is the main activity of the app.
class MainActivity : AppCompatActivity() {

    // Declare variables for the activity's layout binding, adapter, and view model.
    private lateinit var binding: ActivityMainBinding
    private lateinit var myAdapter: MyAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private val viewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflate the activity's layout using the binding.
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set the RecyclerView to have a fixed size.
        binding.recyclerView.setHasFixedSize(true)

        // Create a new LinearLayoutManager and set it as the RecyclerView's layout manager.
        linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = linearLayoutManager

        // Observe the LiveData object returned by the view model's getMyData() method.
        // When the data is updated, create a new adapter with the updated data and set it on the RecyclerView.
        viewModel.getMyData().observe(this) { items ->
            myAdapter = MyAdapter(baseContext, items)
            binding.recyclerView.adapter = myAdapter
        }
    }
}


