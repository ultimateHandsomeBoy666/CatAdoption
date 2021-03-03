package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.model.Cat

interface CatRepository {

    fun getCats(): Result<List<Cat>>

    fun getCat(catId: String): Result<Cat>
}