package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.example.androiddevchallenge.data.CatRepository
import com.example.androiddevchallenge.model.Cat

@Composable
fun HomeScreen(
    catRepository: CatRepository
) {


}

@Composable
fun HomeScreen(
    cats: List<Cat>
) {
    LazyColumn() {

    }
}
