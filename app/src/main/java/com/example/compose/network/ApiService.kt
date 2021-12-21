package com.example.compose.network

import com.example.compose.network.models.Post
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>
}