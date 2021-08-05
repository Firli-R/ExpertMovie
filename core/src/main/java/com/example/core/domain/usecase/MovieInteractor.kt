package com.example.core.domain.usecase

import com.example.core.domain.model.EntityItem
import com.example.core.domain.repository.IMovieRepository

class MovieInteractor(private val movieRepository: IMovieRepository):MovieUseCase {

    override fun getAllFilm() = movieRepository.getAllFilm()

    override fun getFavoriteFilm() = movieRepository.getFavoriteFilm()

    override fun setFavoriteFilm(film: EntityItem, state: Boolean) = movieRepository.setFavoriteFilm(film, state)
}