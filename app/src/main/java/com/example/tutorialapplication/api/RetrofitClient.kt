package com.example.tutorialapplication.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    fun createHttpClient(): HPService {

        //create Retrofit client
        val retrofit = Retrofit.Builder()
            .baseUrl("https://hp-api.onrender.com/api/")
//            .baseUrl("https://run.mocky.io/v3/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()

        return retrofit.create(HPService::class.java)
    }
}