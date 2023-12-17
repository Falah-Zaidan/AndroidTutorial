package com.example.tutorialapplication.util

import com.example.tutorialapplication.api.model.Character
import com.example.tutorialapplication.api.model.Spell
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

var gson = GsonBuilder()
    .create()

var listOfCharacterObjects: Type = object : TypeToken<List<Character>>() {}.type
var listOfSpellObjects: Type = object : TypeToken<List<Spell>>() {}.type

fun serializeCharacterData(jsonData: String): List<Character> {
    return gson.fromJson(jsonData, listOfCharacterObjects)
}

fun serializeSpellData(jsonData: String): List<Spell> {
    return gson.fromJson(jsonData, listOfSpellObjects)
}