package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.CatRepository
import com.example.androiddevchallenge.data.Result
import com.example.androiddevchallenge.data.impl.cats
import com.example.androiddevchallenge.model.Cat
import kotlinx.coroutines.coroutineScope

@Composable
fun HomeScreen(
    catRepository: CatRepository
) {
    val (cats, _) = remember { mutableStateOf(catRepository.getCats()) }
    if (cats is Result.Success) {
        HomeScreen(cats = cats.data)
    }
}

@Composable
fun HomeScreen(
    cats: List<Cat>
) {
    Scaffold(
        topBar = {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .background(color = Color(0xFFFFFFF)),
                text = stringResource(id = R.string.app_name),
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.pink),
                fontSize = 36.sp,
                fontFamily = FontFamily.Cursive
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFFFFF))
        ) {
            items(
                count = cats.size,
                itemContent = { index ->  
                    Spacer(modifier = Modifier.height(24.dp))
                    CatItem(cat = cats[index])
                }
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreView() {
    HomeScreen(cats = cats)
}
