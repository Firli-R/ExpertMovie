package com.example.core.domain.usecase

import com.example.core.data.Resource
import com.example.core.domain.model.EntityItem
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    fun getAllFilm(): Flow<Resource<List<EntityItem>>>
    fun getFavoriteFilm(): Flow<List<EntityItem>>
    fun setFavoriteFilm(tourism: EntityItem, state: Boolean)
}