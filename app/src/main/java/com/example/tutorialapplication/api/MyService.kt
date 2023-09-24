package com.example.tutorialapplication.api

import com.example.tutorialapplication.api.model.Character
import retrofit2.http.GET

interface MyService {

    @GET("characters")
    suspend fun getCharacters(): List<Character>
}