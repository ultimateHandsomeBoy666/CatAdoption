package com.example.androiddevchallenge.ui.home

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import com.example.androiddevchallenge.R
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