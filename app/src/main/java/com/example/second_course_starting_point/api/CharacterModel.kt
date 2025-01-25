package com.example.second_course_starting_point.api

import com.google.gson.annotations.SerializedName

data class CharacterModel(
    @SerializedName("name")
    val name: String,

    @SerializedName("id")
    val id: String,

    @SerializedName("species")
    val species: String,

    @SerializedName("image")
    val image: String,

    // Square brackets means a list (in the JSON), curly braces in JSON mean object

//    "alternate_names": [
//      "The Boy Who Lived",
//      "The Chosen One",
//      "Undesirable No. 1",
//      "Potty"
//    ]

    @SerializedName("alternate_names")
    val alternateNames: List<String>,

//    "wand": {
//      "wood": "holly",
//      "core": "phoenix tail feather",
//      "length": 11
//    }

    @SerializedName("wand")
    var wand: Wand
)

data class Wand(
    @SerializedName("wood")
    val wood: String,
    @SerializedName("core")
    val core: String,
    @SerializedName("length")
    val length: Int // Double

    //@SerializedName("boolean-key")
//    val someBooleanReturnedFromJSON: Boolean
)

// Basic types: Int, Boolean, Float, Double, Char