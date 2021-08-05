package com.example.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EntityItem (
        val description: String?,
        val title: String?,
        val genre: String?,
        val rating: Double?,
        val posterPath: String?,
        val releaseDate: String?,
        val id: Int?,
        val backdropPath :String?,
        val isFavorite: Boolean
        ):Parcelable
    
           
        
  
