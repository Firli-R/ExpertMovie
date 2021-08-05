package com.example.expertmovie.film

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.core.domain.usecase.MovieUseCase


class FilmViewModel(private val movieUseCase: MovieUseCase):ViewModel() {
    fun getFilm() = movieUseCase.getAllFilm().asLiveData()
}