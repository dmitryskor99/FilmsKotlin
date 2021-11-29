package ru.dmitryskor.moviesnt.data.api.entities

import com.google.gson.annotations.SerializedName

data class LinkEntity(
    @SerializedName("type")
    val type: String? = "",

    @SerializedName("url")
    val url: String? = "",

    @SerializedName("suggested_link_text")
    val suggestedLinkText: String? = ""
)
