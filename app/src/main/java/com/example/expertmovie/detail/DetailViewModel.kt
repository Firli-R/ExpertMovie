package com.example.expertmovie.detail

import androidx.lifecycle.ViewModel
import com.example.core.domain.model.EntityItem
import com.example.core.domain.usecase.MovieUseCase

class DetailViewModel(private val movieUseCase: MovieUseCase): ViewModel() {
    fun setFavoriteFilm(film: EntityItem, newStatus:Boolean) =
        movieUseCase.setFavoriteFilm(film, newStatus)
}