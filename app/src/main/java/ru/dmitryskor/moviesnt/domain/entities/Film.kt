package ru.dmitryskor.moviesnt.domain.entities

import android.os.Parcel
import android.os.Parcelable

data class Film(
    val displayTitle: String? = "",
    val mpaaRating: String? = "",
    val criticsPick: Int? = 0,
    val byline: String? = "",
    val headline: String? = "",
    val summaryShort: String? = "",
    val publicationDate: String? = "",
    val openingDate: String? = "",
    val dateUpdated: String? = "",
    val link: Link? = Link(),
    val multimedia: Multimedia? = Multimedia()
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(Link::class.java.classLoader),
        parcel.readParcelable(Multimedia::class.java.classLoader)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(displayTitle)
        parcel.writeString(mpaaRating)
        parcel.writeValue(criticsPick)
        parcel.writeString(byline)
        parcel.writeString(headline)
        parcel.writeString(summaryShort)
        parcel.writeString(publicationDate)
        parcel.writeString(openingDate)
        parcel.writeString(dateUpdated)
        parcel.writeParcelable(link, flags)
        parcel.writeParcelable(multimedia, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Film> {
        override fun createFromParcel(parcel: Parcel): Film {
            return Film(parcel)
        }

        override fun newArray(size: Int): Array<Film?> {
            return arrayOfNulls(size)
        }
    }
}
