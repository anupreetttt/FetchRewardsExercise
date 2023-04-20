package com.example.fetchrewardsexercise.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.fetchrewardsexercise.DataModel.MyDataItem

class MyViewModel : ViewModel() {

    private val repository: MyRepository = MyRepository()

    fun getMyData(): LiveData<List<Pair<Int, List<MyDataItem>>>> {
        return repository.getMyData()
    }

}
