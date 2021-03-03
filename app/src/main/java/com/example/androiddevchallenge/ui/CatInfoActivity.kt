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
import com.example.androiddevchallenge.data.impl.CatRepositoryImpl
import com.example.androiddevchallenge.ui.home.HomeScreen
import com.example.androiddevchallenge.ui.theme.MyTheme

class CatInfoActivity : AppCompatActivity() {

    private val repository = (application as CatAdoptionApplication).repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                CatInfo(repository = repository)
            }
        }
    }
}

// Start building your app here!
@Composable
fun CatInfo(repository: CatRepository) {
    Surface(color = MaterialTheme.colors.background) {
        HomeScreen(repository)
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun CatInfoLightPreview() {
    MyTheme {
        MyApp(CatRepositoryImpl())
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun CatInfoDarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp(CatRepositoryImpl())
    }
}