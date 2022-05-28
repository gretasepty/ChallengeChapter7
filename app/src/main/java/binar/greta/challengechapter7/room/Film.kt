package binar.greta.challengechapter7.room

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Film(
    @PrimaryKey(autoGenerate = true)
    var id : Int?,
    @ColumnInfo(name = "date")
    var date : String?,
    @ColumnInfo(name = "description")
    val description : String?,
    @ColumnInfo(name = "director")
    var director : String?,
    @ColumnInfo(name = "image")
    var image : String?,
    @ColumnInfo(name = "name")
    var name : String?
) : Parcelable
