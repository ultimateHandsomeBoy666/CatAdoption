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

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.impl.cat1
import com.example.androiddevchallenge.model.Cat
import com.example.androiddevchallenge.model.Sex
import com.example.androiddevchallenge.ui.CatInfoActivity

@Composable
fun CatItem(
    cat: Cat
) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 16.dp)
            .clip(shape = RoundedCornerShape(size = 24.dp))
            .background(color = colorResource(id = R.color.yellow))
            .clickable {
                val intent = Intent(context, CatInfoActivity::class.java)
                intent.putExtra("petId", cat.petId)
                context.startActivity(intent)
            },
    ) {
        Image(
            modifier = Modifier
                .size(width = 160.dp, height = 160.dp)
                .clip(shape = RoundedCornerShape(24.dp)),
            painter = painterResource(id = cat.imageThumbId),
            contentDescription = "cat-thumb",
            contentScale = ContentScale.Crop,
        )
        Column(
            modifier = Modifier
                .height(height = 160.dp)
                .fillMaxWidth()
                .align(alignment = Alignment.CenterVertically),
        ) {
            Row(
                modifier = Modifier
                    .wrapContentSize()
                    .align(alignment = Alignment.CenterHorizontally)
            ) {
                Text(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(vertical = 8.dp),
                    text = cat.name,
                    color = colorResource(id = R.color.white),
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center
                )
                Spacer(
                    modifier = Modifier
                        .width(8.dp)
                )
                Icon(
                    modifier = Modifier
                        .size(20.dp, 20.dp)
                        .align(alignment = Alignment.CenterVertically),
                    painter = painterResource(id = getCatSexResId(cat)),
                    contentDescription = "",
                    tint = colorResource(id = R.color.pink)
                )
            }
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                text = cat.breed,
                color = colorResource(id = R.color.grey_white),
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                text = cat.age,
                color = colorResource(id = R.color.grey_white),
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                textAlign = TextAlign.Center,
                text = getCatColor(cat),
                color = colorResource(id = R.color.grey_white),
                fontSize = 14.sp,
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                text = "${cat.weight} pounds",
                color = colorResource(id = R.color.grey_white),
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

fun getCatSexResId(cat: Cat): Int {
    return if (cat.sex == Sex.Female) R.drawable.ic_female else R.drawable.ic_male
}

fun getCatColor(cat: Cat): String {
    val primaryColor = cat.primaryColor ?: ""
    val secondColor = cat.secondaryColor ?: ""
    return when {
        cat.primaryColor == null -> secondColor
        cat.secondaryColor == null -> primaryColor
        else -> "$primaryColor & $secondColor"
    }
}

@Preview
@Composable
fun CardItemPreview() {
    Surface {
        CatItem(cat1)
    }
}
