package com.example.second_course_starting_point.api

import retrofit2.http.GET

interface ApiService {

    @GET("characters")
    fun getCharactersFromAPI(): List<CharacterModel>
}