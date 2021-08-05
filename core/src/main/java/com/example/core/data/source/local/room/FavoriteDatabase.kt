package com.example.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core.data.source.local.entity.EntityFilm

@Database(entities = [EntityFilm::class], version = 1, exportSchema = false)
abstract class
FavoriteDatabase : RoomDatabase() {
    abstract fun favDao(): FavoriteDao
}