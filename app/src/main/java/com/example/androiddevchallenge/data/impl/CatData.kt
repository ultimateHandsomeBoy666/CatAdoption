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
package com.example.androiddevchallenge.data.impl

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Cat
import com.example.androiddevchallenge.model.Sex

val cat1 = Cat(
    name = "Angle",
    petId = "20836",
    imageId = R.drawable.cat1,
    imageThumbId = R.drawable.cat1_thumb,
    breed = "Domestic Shorthair",
    sex = Sex.Female,
    age = "5yrs 0mths 0wks",
    primaryColor = "White",
    weight = "8.7",
)

val cat2 = Cat(
    name = "Booboo",
    petId = "20857",
    imageId = R.drawable.cat2,
    imageThumbId = R.drawable.cat2_thumb,
    breed = "Domestic Shorthair",
    sex = Sex.Male,
    age = "2yrs 0mths 0wks",
    primaryColor = "Black",
    secondaryColor = "Black",
    weight = "10.8",
)

val cat3 = Cat(
    name = "Chris",
    petId = "20838",
    imageId = R.drawable.cat3,
    imageThumbId = R.drawable.cat3_thumb,
    breed = "Domestic Shorthair",
    sex = Sex.Male,
    age = "1yrs 0mths 0wks",
    primaryColor = "White",
    weight = "7",
)

val cat4 = Cat(
    name = "Cowgirl",
    petId = "20585",
    imageId = R.drawable.cat4,
    imageThumbId = R.drawable.cat4_thumb,
    breed = "Domestic Shorthair",
    sex = Sex.Female,
    age = "1yrs 0mths 0wks",
    primaryColor = "Black",
    secondaryColor = "White",
    weight = "6.2",
)

val cat5 = Cat(
    name = "Daisy",
    petId = "20859",
    imageId = R.drawable.cat5,
    imageThumbId = R.drawable.cat5_thumb,
    breed = "Domestic Shorthair",
    sex = Sex.Female,
    age = "3yrs 0mths 0wks",
    primaryColor = "Calico",
    weight = "9.6",
)

val cat6 = Cat(
    name = "Evie",
    petId = "20737",
    imageId = R.drawable.cat6,
    imageThumbId = R.drawable.cat6_thumb,
    breed = "Domestic Shorthair",
    sex = Sex.Female,
    age = "1yrs 0mths 3wks",
    primaryColor = "Black",
    weight = "10.6",
    secondaryColor = "White"
)

val cat7 = Cat(
    name = "Golden",
    petId = "20858",
    imageId = R.drawable.cat7,
    imageThumbId = R.drawable.cat7_thumb,
    breed = "Domestic Shorthair",
    sex = Sex.Male,
    age = "1yrs 0mths 0wks",
    primaryColor = "White",
    weight = "14.2",
    secondaryColor = "Orange Tabby"
)

val cat8 = Cat(
    name = "Kiss",
    petId = "20651",
    imageId = R.drawable.cat8,
    imageThumbId = R.drawable.cat8_thumb,
    breed = "Domestic Shorthair",
    sex = Sex.Female,
    age = "2yrs 1mths 0wks",
    primaryColor = "Black",
    weight = "7.6",
    secondaryColor = "White"
)

val cat9 = Cat(
    name = "Maude",
    petId = "20642",
    imageId = R.drawable.cat9,
    imageThumbId = R.drawable.cat9_thumb,
    breed = "Domestic Shorthair",
    sex = Sex.Female,
    age = "2yrs 1mths 0wks",
    primaryColor = "Black",
    weight = "11.5",
    secondaryColor = "White"
)

val cat10 = Cat(
    name = "Oscar",
    petId = "20828",
    imageId = R.drawable.cat10,
    imageThumbId = R.drawable.cat10_thumb,
    breed = "Domestic Shorthair",
    sex = Sex.Male,
    age = "3yrs 0mths 1wks",
    primaryColor = "Orange Tabby",
    weight = "10.14",
    secondaryColor = "White"
)

val cats = listOf<Cat>(
    cat1,
    cat2,
    cat3,
    cat4,
    cat5,
    cat6,
    cat7,
    cat8,
    cat9,
    cat10
)
