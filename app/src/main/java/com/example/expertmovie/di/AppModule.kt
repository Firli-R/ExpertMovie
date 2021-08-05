package com.example.expertmovie.di

import com.example.core.domain.usecase.MovieInteractor
import com.example.core.domain.usecase.MovieUseCase
import com.example.expertmovie.detail.DetailViewModel
import com.example.expertmovie.film.FilmViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { FilmViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}