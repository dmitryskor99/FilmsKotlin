package ru.dmitryskor.moviesnt.data.api.entities

import com.google.gson.annotations.SerializedName

data class FilmsResponse(
    @SerializedName("status")
    val status: String = "",

    @SerializedName("copyright")
    val copyright: String = "",

    @SerializedName("has_more")
    val hasMore: Boolean = false,

    @SerializedName("num_results")
    val numResults: Int = 0,

    @SerializedName("results")
    val results: List<FilmEntity>?
)