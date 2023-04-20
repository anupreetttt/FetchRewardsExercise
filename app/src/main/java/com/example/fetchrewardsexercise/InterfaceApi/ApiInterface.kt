package com.example.fetchrewardsexercise.InterfaceApi

import com.example.fetchrewardsexercise.DataModel.MyDataItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("hiring.json")
    fun getdata(): Call<List<MyDataItem>>
}