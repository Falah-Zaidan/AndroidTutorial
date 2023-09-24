package com.example.tutorialapplication.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Character(

    @SerializedName("id")
    @Expose
    val id: String,

    @SerializedName("name")
    @Expose
    val name: String?,

    @SerializedName("alternate_names")
    @Expose
    val alternate_names: List<String>?,

    @SerializedName("species")
    val species: String?,

    @SerializedName("gender")
    val gender: String?,

    @SerializedName("house")
    val house: String?,

    @SerializedName("dateOfBirth")
    val dateOfBirth: String?,

    @SerializedName("yearOfBirth")
    val yearOfBirth: String?,

    @SerializedName("wizard")
    val wizard: Boolean?,

    @SerializedName("ancestry")
    val ancestry: String?,

    @SerializedName("eyeColour")
    val eyeColour: String?,

    @SerializedName("hairColour")
    val hairColour: String?,

    @SerializedName("wand")
    val wand: Wand,

    @SerializedName("patronus")
    val patronus: String?,

    @SerializedName("hogwartsStudent")
    val hogwartsStudent: String?,

    @SerializedName("hogwartsStaff")
    val hogwartsStaff: String?,

    @SerializedName("actor")
    val actor: String?,

    @SerializedName("alternate_actors")
    val alternate_actors: List<String>,

    @SerializedName("alive")
    val alive: String?,

    @SerializedName("image")
    val image: String?
)

data class Wand(

    @SerializedName("wood")
    val wood: String,

    @SerializedName("core")
    val core: String,

    @SerializedName("length")
    val length: Double
)
