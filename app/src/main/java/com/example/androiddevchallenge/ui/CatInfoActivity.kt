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
import com.example.androiddevchallenge.data.impl.CatRepositoryImpl
import com.example.androiddevchallenge.data.impl.cat1
import com.example.androiddevchallenge.ui.cat.CatInfoScreen
import com.example.androiddevchallenge.ui.home.HomeScreen
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
