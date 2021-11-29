package ru.dmitryskor.moviesnt.data.api.entities

import com.google.gson.annotations.SerializedName

data class MultimediaEntity(
    @SerializedName("type")
    val type: String? = "",

    @SerializedName("src")
    val src: String? = "",

    @SerializedName("width")
    val width: Int? = 0,

    @SerializedName("height")
    val height: Int? = 0
)
