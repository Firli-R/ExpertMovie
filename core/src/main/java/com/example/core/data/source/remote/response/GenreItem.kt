package com.example.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class GenreItem(
    @SerializedName("id")
    val id: Int? = 0,

    @SerializedName("name")
    var name: String? = null
)
