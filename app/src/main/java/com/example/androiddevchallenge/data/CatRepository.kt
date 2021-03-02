package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.model.Cat

interface CatRepository {

    suspend fun getCats(): Result<List<Cat>>

    suspend fun getCat(catId: String): Result<Cat>
}