package com.pankti.l1programmingquestions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

val users = listOf("Pinu", "Pankti", "Pinki", "Palak", "Pinya")

class MyViewModel : ViewModel() {

    private var _userList = MutableLiveData<List<String>>()
    var userList: LiveData<List<String>> = _userList



    init {
        println("@@@@ VM init")
        viewModelScope.launch {
            delay(5000)
        }
        fetchUserData()
    }

    private fun fetchUserData() {
        _userList.value = users // it is using setValue()
        // If there are active observers, the value will be dispatched to them.
        // This method must be called from the main thread.
        // If you need set a value from a background thread, you can use postValue(Object)
    }
}