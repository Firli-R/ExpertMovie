package com.example.core.data.source.local

import com.example.core.data.source.local.entity.EntityFilm
import com.example.core.data.source.local.room.FavoriteDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val mFavoriteDao: FavoriteDao) {

    fun getAllFilm(): Flow<List<EntityFilm>> = mFavoriteDao.getAllFilm()

    fun getFavoriteFilm(): Flow<List<EntityFilm>> = mFavoriteDao.getFavoriteFilm()

    suspend fun insertFilm(filmList: List<EntityFilm>) = mFavoriteDao.insertFilm(filmList)

    fun setFavoriteFilm(film: EntityFilm, newState: Boolean) {
        film.isFavorite = newState
        mFavoriteDao.updateFavoriteFilm(film)
    }
}
