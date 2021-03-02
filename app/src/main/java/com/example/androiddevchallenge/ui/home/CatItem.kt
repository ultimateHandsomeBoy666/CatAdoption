package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.impl.cats
import com.example.androiddevchallenge.model.Cat


@Composable
fun CatItem(
    cat: Cat
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 20.dp),
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
                .fillMaxWidth()
                .height(height = 112.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                modifier = Modifier
                    .wrapContentSize(),
                text = "!!!!!!!!@!@#!@#!#!@#@!",
                color = Color.Black
            )
        }
    }
}

@Preview
@Composable
fun CardItemPreview() {
    Surface {
        CatItem(cats[1])
    }
}