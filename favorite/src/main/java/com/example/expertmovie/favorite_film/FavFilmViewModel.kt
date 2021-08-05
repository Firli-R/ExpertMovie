package com.example.expertmovie.favorite_film

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.core.domain.usecase.MovieUseCase


class FavFilmViewModel(private val movieUseCase: MovieUseCase): ViewModel() {
    fun getFilm() = movieUseCase.getFavoriteFilm().asLiveData()
}