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

import com.example.androiddevchallenge.data.CatRepository
import com.example.androiddevchallenge.data.Result
import com.example.androiddevchallenge.model.Cat
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
