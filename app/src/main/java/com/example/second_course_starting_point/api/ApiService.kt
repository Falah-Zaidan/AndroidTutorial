package com.example.second_course_starting_point.api

import retrofit2.http.GET

interface ApiService {

    @GET("/path")
    fun getCharactersFromAPI()
}