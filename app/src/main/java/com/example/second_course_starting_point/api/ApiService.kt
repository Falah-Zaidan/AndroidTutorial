package com.example.second_course_starting_point.api

import retrofit2.http.GET

interface ApiService {

    // Retrofit doesn't support List as the return type, use suspend and Flow as the return type
    @GET("characters")
    suspend fun getCharactersFromAPI(): List<CharacterModel>
}