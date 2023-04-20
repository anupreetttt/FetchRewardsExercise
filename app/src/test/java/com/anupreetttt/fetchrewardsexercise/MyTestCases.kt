package com.anupreetttt.fetchrewardsexercise

import androidx.lifecycle.LiveData
import com.anupreetttt.fetchrewardsexercise.viewModel.MyRepository
import com.anupreetttt.fetchrewardsexercise.viewModel.MyViewModel
import junit.framework.TestCase.*
import org.junit.Test

class MyTestCases {

    // Test the LiveData object returned by the view model:
    @Test
    fun viewModel_getMyData_returnsLiveData() {
        val viewModel = MyViewModel()
        assertTrue(viewModel.getMyData() is LiveData)
    }

// This test case is getting the data from a repository, sorting each list of MyDataItems by listId
    @Test
    fun testSorting() {
        val repository = MyRepository()
        val liveData = repository.getMyData()
        val sortedList = liveData.value?.flatMap { it.second }?.sortedWith(compareBy({ it.listId }, { it.name!!.split(" ")[1].toInt() }))
        assertEquals(sortedList, liveData.value?.flatMap { it.second })
    }



}