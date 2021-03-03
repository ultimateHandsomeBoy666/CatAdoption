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
package com.example.androiddevchallenge.ui.cat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.impl.cat1
import com.example.androiddevchallenge.model.Cat
import com.example.androiddevchallenge.ui.home.getCatColor

@Composable
fun CatInfoScreen(cat: Cat) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .scrollable(
                state = ScrollableState { float -> float },
                orientation = Orientation.Vertical
            )
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color.White)
        ) {
            val (img, card, text) = createRefs()
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(320.dp)
                    .constrainAs(img) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                    },
                painter = painterResource(id = cat.imageId),
                contentScale = ContentScale.Crop,
                contentDescription = "cat image",
            )
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(horizontal = 48.dp)
                    .shadow(elevation = 4.dp)
                    .clip(shape = RoundedCornerShape(size = 18.dp))
                    .background(color = colorResource(id = R.color.white))
                    .constrainAs(card) {
                        start.linkTo(parent.start, margin = 96.dp)
                        end.linkTo(parent.end, margin = 96.dp)
                        top.linkTo(img.bottom)
                        bottom.linkTo(img.bottom)
                    }
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(bottom = 16.dp),
                    textAlign = TextAlign.Center,
                    text = cat.name,
                    color = colorResource(id = R.color.black),
                    fontSize = 24.sp,
                    fontFamily = FontFamily.SansSerif
                )
                Text(
                    modifier = Modifier
                        .wrapContentSize()
                        .align(Alignment.CenterHorizontally),
                    text = cat.breed,
                    textAlign = TextAlign.Center,
                )
                Text(
                    modifier = Modifier
                        .wrapContentSize()
                        .align(Alignment.CenterHorizontally),
                    text = cat.age,
                    textAlign = TextAlign.Center,
                )
                Text(
                    modifier = Modifier
                        .wrapContentSize()
                        .align(Alignment.CenterHorizontally),
                    text = getCatColor(cat),
                    textAlign = TextAlign.Center,
                )
                Text(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(bottom = 8.dp)
                        .align(Alignment.CenterHorizontally),
                    text = "${cat.weight} pounds",
                    textAlign = TextAlign.Center,
                )
            }
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .constrainAs(text) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(card.bottom, margin = 36.dp)
                    },
                text = stringResource(id = R.string.adoption_info),
                color = Color.Black,
                fontSize = 20.sp,
            )
        }
    }
}

@Preview
@Composable
fun CatInfoPreview() {
    CatInfoScreen(cat = cat1)
}
