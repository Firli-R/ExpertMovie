package com.example.expertmovie.favorite_film.di

import com.example.expertmovie.favorite_film.FavFilmViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoriteModule = module {
    viewModel { FavFilmViewModel(get()) }
}