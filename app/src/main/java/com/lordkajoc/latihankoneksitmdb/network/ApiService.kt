package com.lordkajoc.latihan_retrofit.network

import com.lordkajoc.latihankoneksitmdb.model.GetAllFilmTMDB
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    //GET digunakan untuk memanggil semua data yang terdapat pada server
//    @GET("news")
//    fun getAllNews(): Call<List<GetAllNewsResponesItem>>
//
//    @GET("film")
//    fun getAllFilm(): Call<List<GetAllFIlmResponseItem>>

    @GET("movie/popular?")
    fun getmovie(
        @Query("api_key") APIKEY: String,
        @Query("page") PAGE: Int
    ): Call<GetAllFilmTMDB<com.lordkajoc.latihankoneksitmdb.model.GetAllFilmResponse>>

}