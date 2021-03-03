package com.example.androiddevchallenge

import android.app.Application
import com.example.androiddevchallenge.data.CatRepository
import com.example.androiddevchallenge.data.impl.CatRepositoryImpl

class CatAdoptionApplication : Application() {

    lateinit var repository: CatRepository

    override fun onCreate() {
        super.onCreate()
        repository = CatRepositoryImpl()
    }
}