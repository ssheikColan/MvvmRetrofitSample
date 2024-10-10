package com.example.mvvmsample

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    private val repository = UserRepository()

    fun getUsers(page: Int): LiveData<List<User>> {
        return repository.getUsers(page)
    }
}
