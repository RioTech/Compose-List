package com.example.compose.ui.main

import com.example.compose.network.models.Post

data class ListState(
    val isLoading : Boolean = true,
    val listOfItems : List<Post> = emptyList()
)