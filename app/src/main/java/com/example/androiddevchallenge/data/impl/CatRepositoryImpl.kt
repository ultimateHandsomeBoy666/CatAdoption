package com.example.androiddevchallenge.data.impl

import com.example.androiddevchallenge.data.CatRepository
import com.example.androiddevchallenge.data.Result
import com.example.androiddevchallenge.model.Cat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlin.random.Random

class CatRepositoryImpl : CatRepository {

    override fun getCats(): Result<List<Cat>> {
        return if (shouldRandomlyFail()) {
                    Result.Error(IllegalStateException())
                } else {
                    Result.Success(cats)
                }
    }

    override fun getCat(catId: String): Result<Cat> {
        val cat = cats.find { it.petId == catId }
        return if (cat == null) {
            Result.Error(IllegalArgumentException("Cat not found"))
        } else {
            Result.Success(cat)
        }
    }

    private fun shouldRandomlyFail(): Boolean = Random(1).nextInt(1, 100) == 200

}