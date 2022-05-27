package binar.greta.challengechapter7.network

import binar.greta.challengechapter7.model.GetAllFilmItem
import binar.greta.challengechapter7.model.GetAllUserItem
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("film")
    suspend fun getAllFilm() : List<GetAllFilmItem>

    @GET("user")
    fun getAllUser(
        @Query("username") username : String
    ) : Call<GetAllUserItem>

    @GET("user")
    fun allUser() : Call<List<GetAllUserItem>>

    @POST("user")
    @FormUrlEncoded
    fun loginUser(
        @Field("password") password : String,
        @Field("username") username : String
    ) : Call<GetAllUserItem>

    @POST("user")
    @FormUrlEncoded
    fun registerUser(
        @Field("password") password : String,
        @Field("username") username : String
    ) : Call<GetAllUserItem>

    @POST("user")
    @FormUrlEncoded
    fun updateUser(
        @Field("id")id : String,
        @Field("address") address : String,
        @Field("name") name : String,
        @Field("password") password : String,
        @Field("umur") umur : String,
        @Field("username") username : String
    ) : Call<GetAllUserItem>


}