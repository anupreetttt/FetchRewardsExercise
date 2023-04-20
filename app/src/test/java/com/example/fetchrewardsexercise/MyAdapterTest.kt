package com.example.fetchrewardsexercise

import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchrewardsexercise.viewModel.MyRepository
import com.example.fetchrewardsexercise.viewModel.MyViewModel
import junit.framework.TestCase.*
import org.junit.Test
import org.robolectric.Robolectric

class MyAdapterTest {

    // Test the LiveData object returned by the view model:
    @Test
    fun viewModel_getMyData_returnsLiveData() {
        val viewModel = MyViewModel()
        assertTrue(viewModel.getMyData() is LiveData)
    }


    @Test
    fun testSorting() {
        val repository = MyRepository()
        val liveData = repository.getMyData()
        val sortedList = liveData.value?.flatMap { it.second }?.sortedWith(compareBy({ it.listId }, { it.name!!.split(" ")[1].toInt() }))
        assertEquals(sortedList, liveData.value?.flatMap { it.second })
    }



}