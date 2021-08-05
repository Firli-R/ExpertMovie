package com.example.core.data.source.remote.network

import com.example.core.data.source.remote.response.ResponseFilm


import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("3/movie/popular")
    suspend fun resultItemFilm(
        @Query("api_key")api_key:String
    ):ResponseFilm

}