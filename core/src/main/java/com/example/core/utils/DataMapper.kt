package com.example.core.utils

import com.example.core.data.source.local.entity.EntityFilm
import com.example.core.data.source.remote.response.ResultsItemFilm
import com.example.core.domain.model.EntityItem

object DataMapper {
    fun mapResponsesToEntities(input: List<ResultsItemFilm>): List<EntityFilm> {
        val filmList = ArrayList<EntityFilm>()
        input.map {
            val film = EntityFilm(
                it.description,
                it.title,
                it.posterPath,
                it.releaseDate,
                it.id,
                "",
                it.score.toString(),
                it.backdropPath,
                false
            )
            filmList.add(film)
        }
        return filmList
    }

    fun mapEntitiesToDomain(input: List<EntityFilm>): List<EntityItem> =
        input.map {
            EntityItem(
                it.description,
                it.title,
                "",
                it.rating!!.toDouble(),
                it.posterPath,
                it.releaseDate,
                it.id,
                it.backdropPath,
                it.isFavorite
            )
        }
    fun mapDomainToEntity(input: EntityItem) = EntityFilm(
        input.description,
        input.title,
        input.posterPath,
        input.releaseDate,
        input.id,
        "",
        input.rating.toString(),
        input.backdropPath,
        input.isFavorite
    )

}