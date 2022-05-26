package binar.greta.challengechapter7.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import binar.greta.challengechapter7.model.GetAllFilmItem

@Dao
interface DaoFilm {
    @Insert
    fun addFilm(film : Film) : Long

    @Query("SELECT * FROM Film")
    fun getFilm() : List<Film>

    @Delete
    fun deleteFilm(film: Film) : Int

}