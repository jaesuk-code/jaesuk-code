package com.example.work5_housekeepingbook

import android.os.Parcel
import android.os.Parcelable

// Dto
class List (var seq:Int, var usage:String?, var date:String?, var price:Int, var memo:String?):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, p1: Int) {
        parcel.writeInt(seq)
        parcel.writeString(usage)
        parcel.writeString(date)
        parcel.writeInt(price)
        parcel.writeString(memo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<List> {
        override fun createFromParcel(parcel: Parcel): List {
            return List(parcel)
        }

        override fun newArray(size: Int): Array<List?> {
            return arrayOfNulls(size)
        }
    }

}