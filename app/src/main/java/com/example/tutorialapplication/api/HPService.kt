package com.example.tutorialapplication.api

import com.example.tutorialapplication.api.model.Character
import com.example.tutorialapplication.api.model.Spell
import retrofit2.http.GET

interface HPService {

    @GET("characters")
    suspend fun getCharacters(): List<Character>

    @GET("spells")
    suspend fun getSpells(): List<Spell>

//    @GET("f450d07f-56bd-45d7-91a2-0ec7cae12984")
//    suspend fun getCharacters(): List<Character>
}