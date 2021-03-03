package com.example.androiddevchallenge.ui.cat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
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
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.example.androiddevchallenge.data.impl.cat1
import com.example.androiddevchallenge.model.Cat
import com.example.androiddevchallenge.R
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
                    .padding(vertical = 8.dp)
                    .clip(shape = RoundedCornerShape(size = 18.dp))
                    .background(color = colorResource(id = R.color.white))
                    .constrainAs(card) {
                        start.linkTo(parent.start, margin = 96.dp)
                        end.linkTo(parent.end, margin = 96.dp)
                        top.linkTo(img.bottom)
                        bottom.linkTo(img.bottom)
                    }
                    .shadow(elevation = 4.dp)
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
                        .align(Alignment.CenterHorizontally),
                    text = "${cat.weight} pounds",
                    textAlign = TextAlign.Center,
                )
            }
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = 16.dp)
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