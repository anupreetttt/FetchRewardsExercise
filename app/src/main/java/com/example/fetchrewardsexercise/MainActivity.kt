package com.example.fetchrewardsexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fetchrewardsexercise.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val BASE_URL = "https://fetch-hiring.s3.amazonaws.com/"
    lateinit var myAdapter: MyAdapter
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.setHasFixedSize(true)

        linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = linearLayoutManager
        getMyData();
    }

    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getdata()

        retrofitData.enqueue(object : Callback<List<MyDataItem>?> {
            override fun onResponse(
                call: Call<List<MyDataItem>?>,
                response: Response<List<MyDataItem>?>
            ) {
                val responseBody = response.body()!!
                val items = responseBody
                    .filter { !it.name.isNullOrEmpty() }
                    .sortedWith(compareBy({ it.listId }, { it.name }))
                    .groupBy { it.listId }
                    .toList()

                myAdapter = MyAdapter(baseContext, items)
                binding.recyclerView.adapter = myAdapter
            }

            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
                d("ERROR", "onFailure")
            }
        })
    }
}
