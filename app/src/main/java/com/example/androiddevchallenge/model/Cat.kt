package com.example.androiddevchallenge.model

import androidx.annotation.DrawableRes

data class Cat(
    val name: String,
    val petId: String,
    @DrawableRes val imageId: Int,
    @DrawableRes val imageThumbId: Int,
    val breed: String,
    val sex: Sex,
    val age: String,
    val primaryColor: String? = null,
    val secondaryColor: String? = null,
    val weight: String,
    val shelter: Shelter = Shelter
)

enum class Sex(val sex: String) {
    Male("Male"),
    Female("Female")
}