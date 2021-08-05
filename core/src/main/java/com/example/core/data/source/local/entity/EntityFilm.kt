package com.example.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "favoriteFilm")
data class EntityFilm(
    @NonNull
    val description: String?,
    @NonNull
    val title: String?,
    @NonNull
    val posterPath: String?,
    @NonNull
    val releaseDate: String?,
    @PrimaryKey
    @NonNull
    val id: Int?,
    @NonNull
    val genre: String?,
    @NonNull
    val rating: String?,
    @NonNull
    val backdropPath: String?,
    @NonNull
    var isFavorite: Boolean = false
): Serializable
