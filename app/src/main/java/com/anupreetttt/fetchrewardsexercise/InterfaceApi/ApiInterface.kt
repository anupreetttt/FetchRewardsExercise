package com.anupreetttt.fetchrewardsexercise.InterfaceApi

import com.anupreetttt.fetchrewardsexercise.DataModel.MyDataItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("hiring.json")
    fun getdata(): Call<List<MyDataItem>>
}