/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
