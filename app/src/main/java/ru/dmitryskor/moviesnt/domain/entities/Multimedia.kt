package ru.dmitryskor.moviesnt.domain.entities

import android.os.Parcel
import android.os.Parcelable

data class Multimedia(
    val type: String? = "",
    val src: String? = "",
    val width: Int? = 0,
    val height: Int? = 0
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(type)
        parcel.writeString(src)
        parcel.writeValue(width)
        parcel.writeValue(height)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Multimedia> {
        override fun createFromParcel(parcel: Parcel): Multimedia {
            return Multimedia(parcel)
        }

        override fun newArray(size: Int): Array<Multimedia?> {
            return arrayOfNulls(size)
        }
    }
}
