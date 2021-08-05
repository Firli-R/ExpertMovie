package com.example.core.data.source.local.room

import androidx.room.*
import com.example.core.data.source.local.entity.EntityFilm
import kotlinx.coroutines.flow.Flow


@Dao
interface FavoriteDao {

    @Query("SELECT * FROM favoriteFilm")
    fun getAllFilm(): Flow<List<EntityFilm>>

    @Query("SELECT * FROM favoriteFilm where isFavorite = 1")
    fun getFavoriteFilm(): Flow<List<EntityFilm>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFilm(film: List<EntityFilm>)

    @Update
    fun updateFavoriteFilm(film: EntityFilm)

}