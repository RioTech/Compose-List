package com.example.compose.repository

import android.util.Log
import com.example.compose.network.ApiService
import com.example.compose.network.models.Post
import javax.inject.Inject

class ListRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getList(): List<Post>? {
        val data = apiService.getPosts().body()
        Log.i("RAVI > ", "getList: $data")
        return data
    }
}
