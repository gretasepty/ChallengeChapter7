package binar.greta.challengechapter7.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Film(
    @PrimaryKey(autoGenerate = true)
    var id : Int?,
    @ColumnInfo(name = "date")
    var date : String?,
    @ColumnInfo(name = "director")
    var director : String?,
    @ColumnInfo(name = "image")
    var image : String?,
    @ColumnInfo(name = "name")
    var name : String?
)
