package kz.example.bottomnavigationsample

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

/**
 * @author Arslan Tsoy <t.me/arslantsoy> on 6/19/21
 */

class MyCustomClass(
    val profileName: String,
    val id: Int
): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(profileName)
        parcel.writeInt(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MyCustomClass> {
        override fun createFromParcel(parcel: Parcel): MyCustomClass {
            return MyCustomClass(parcel)
        }

        override fun newArray(size: Int): Array<MyCustomClass?> {
            return arrayOfNulls(size)
        }
    }


}