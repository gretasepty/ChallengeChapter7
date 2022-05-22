package binar.greta.challengechapter7.network

import binar.greta.challengechapter7.model.GetAllFilmItem
import retrofit2.http.GET

interface ApiService {

    @GET("film")
    suspend fun getAllFilm() : List<GetAllFilmItem>
}