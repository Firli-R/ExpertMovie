package com.example.core.domain.repository


import com.example.core.data.Resource
import com.example.core.domain.model.EntityItem
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {

    fun getAllFilm(): Flow<Resource<List<EntityItem>>>

    fun getFavoriteFilm(): Flow<List<EntityItem>>

    fun setFavoriteFilm(film: EntityItem, state: Boolean)
}