package com.crassvs.losinson.models

import com.google.gson.annotations.SerializedName

data class Personaje(

    @SerializedName("quote")
    val frase: String,
    @SerializedName("character")
    val personaje: String,
    @SerializedName("image")
    val imagen: String,
    @SerializedName("characterDirection")
    val direccion: String
)
