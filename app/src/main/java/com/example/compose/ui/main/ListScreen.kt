package com.example.compose.ui.main

import android.content.res.Configuration
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ListScreen(viewModel: MainViewModel) {
    ListScreen(listState = viewModel.listState, viewModel::getList)
}

@Composable
fun ListScreen(listState: ListState, getList: () -> Unit = {}) {
    val lazyListState = rememberLazyListState()
    getList()

    Scaffold {
        if (listState.isLoading) ShowProgressBar()
        else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                state = lazyListState,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val list = listState.listOfItems
                items(list.size) {
                    Item(list[it].title)
                }
            }
        }
    }
}

@Composable
private fun Item(title: String) {
    Text(
        text = title,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        style = MaterialTheme.typography.body1
    )
}

@Composable
private fun ListScreenPreview() {
    ListScreen(listState = ListState(false, emptyList()))
}

@Composable
fun ShowProgressBar() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
        Text(text = "Loading Universe")
    }
}

@Composable
@Preview(
    device = Devices.PIXEL_2,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
private fun ListScreenPreview_DarkMode() {
    ListScreenPreview()
}

@Composable
@Preview(
    device = Devices.PIXEL_2,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
private fun ListScreenPreview_LightMode() {
    ListScreenPreview()
}