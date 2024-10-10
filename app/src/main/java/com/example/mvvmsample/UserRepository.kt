package com.example.mvvmsample

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class UserRepository {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://reqres.in/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService = retrofit.create(ApiService::class.java)

    fun getUsers(page: Int): LiveData<List<User>> {
        val data = MutableLiveData<List<User>>()
        apiService.getUsers(page).enqueue(object : retrofit2.Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: retrofit2.Response<UserResponse>) {
                if (response.isSuccessful) {
                    data.value = response.body()?.data
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                // Handle error
            }
        })
        return data
    }
}
