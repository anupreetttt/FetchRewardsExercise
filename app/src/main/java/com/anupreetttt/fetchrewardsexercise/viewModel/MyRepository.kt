package com.anupreetttt.fetchrewardsexercise.viewModel

import android.util.Log.d
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.anupreetttt.fetchrewardsexercise.DataModel.MyDataItem
import com.anupreetttt.fetchrewardsexercise.InterfaceApi.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// This class represents a repository that provides access to data from an API.
class MyRepository {

    // Define an instance of the API interface using Retrofit.
    private val apiService: ApiInterface = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://fetch-hiring.s3.amazonaws.com/")
        .build()
        .create(ApiInterface::class.java)

    // This method retrieves data from the API and returns it as a LiveData object.
    fun getMyData(): LiveData<List<Pair<Int, List<MyDataItem>>>> {
        // Create a new MutableLiveData object to hold the data.
        val data = MutableLiveData<List<Pair<Int, List<MyDataItem>>>>()

        // Use the API interface to retrieve the data asynchronously.
        apiService.getdata().enqueue(object : Callback<List<MyDataItem>?> {
            override fun onResponse(
                call: Call<List<MyDataItem>?>,
                response: Response<List<MyDataItem>?>
            ) {
                // If the API call is successful, process the data and update the LiveData object.
                val responseBody = response.body()!!
                val items = responseBody
                    .filter { !it.name.isNullOrEmpty() }
                    .sortedWith(compareBy({ it.listId }, { it.name!!.split(" ")[1].toInt() }))
                    .groupBy { it.listId }
                    .toList()
                data.value = items
            }

            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
                // If the API call fails, log an error message.
                d("ERROR", "onFailure")
            }
        })

        // Return the LiveData object.
        return data
    }
}

