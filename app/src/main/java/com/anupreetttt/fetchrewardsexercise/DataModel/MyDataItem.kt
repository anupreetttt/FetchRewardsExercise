package com.anupreetttt.fetchrewardsexercise.DataModel

data class MyDataItem(
    val id: Int,
    val listId: Int,
    val name: String?,
    var visibility: Boolean = false
)