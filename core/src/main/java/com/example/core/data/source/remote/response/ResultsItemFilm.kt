package com.example.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ResultsItemFilm(
        
        @SerializedName("overview")
        var description: String? = null,
        
        @SerializedName("title")
        var title: String? = null,

        @SerializedName("genres")
        var genres: ArrayList<GenreItem>? = null,
        
        @SerializedName("poster_path")
        var posterPath: String? = null,

        @SerializedName("vote_average")
        var score: Double? = null,
        
        @SerializedName("release_date")
        var releaseDate: String? = null,
        
        @SerializedName("id")
        var id: Int? = 0,

        @SerializedName("backdrop_path")
        var backdropPath: String? = null
)