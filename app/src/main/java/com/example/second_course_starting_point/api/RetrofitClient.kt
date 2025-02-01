package com.example.second_course_starting_point.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient { // only want one client in the app
    // converter required to go from JSON to our Modelled objects
    fun createHttpClient(): ApiService {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://hp-api.onrender.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofitBuilder.create(ApiService::class.java)
    }
}