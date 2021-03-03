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
package com.example.androiddevchallenge.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.CatAdoptionApplication
import com.example.androiddevchallenge.data.CatRepository
import com.example.androiddevchallenge.data.Result
import com.example.androiddevchallenge.data.impl.cat1
import com.example.androiddevchallenge.ui.cat.CatInfoScreen
import com.example.androiddevchallenge.ui.theme.MyTheme

class CatInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val petId = intent.extras?.get("petId")
        setContent {
            MyTheme {
                CatInfo(repository = (application as CatAdoptionApplication).repository, petId = petId as String?)
            }
        }
    }
}

// Start building your app here!
@Composable
fun CatInfo(repository: CatRepository, petId: String?) {
    Surface(color = MaterialTheme.colors.background) {
        petId?.let {
            val cat = (repository.getCat(petId) as Result.Success).data
            CatInfoScreen(cat = cat)
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun CatInfoLightPreview() {
    MyTheme {
        CatInfoScreen(cat = cat1)
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun CatInfoDarkPreview() {
    MyTheme(darkTheme = true) {
        CatInfoScreen(cat = cat1)
    }
}
