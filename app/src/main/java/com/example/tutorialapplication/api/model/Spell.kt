package com.example.tutorialapplication.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Spell(

    @SerializedName("id")
    @Expose
    val id: String,

    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("description")
    @Expose
    val description: String,
)