package ru.dmitryskor.moviesnt.data.api.entities

import com.google.gson.annotations.SerializedName

data class FilmEntity(
    @SerializedName("display_title")
    val displayTitle: String? = "",

    @SerializedName("mpaa_rating")
    val mpaaRating: String? = "",

    @SerializedName("critics_pick")
    val criticsPick: Int? = 0,

    @SerializedName("byline")
    val byline: String? = "",

    @SerializedName("headline")
    val headline: String? = "",

    @SerializedName("summary_short")
    val summaryShort: String? = "",

    @SerializedName("publication_date")
    val publicationDate: String? = "",

    @SerializedName("opening_date")
    val openingDate: String? = "",

    @SerializedName("date_updated")
    val dateUpdated: String? = "",

    @SerializedName("link")
    val link: LinkEntity? = LinkEntity(),

    @SerializedName("multimedia")
    val multimedia: MultimediaEntity? = MultimediaEntity()
)
