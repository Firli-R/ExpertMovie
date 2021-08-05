package com.example.core.data

import com.example.core.data.source.local.LocalDataSource
import com.example.core.data.source.remote.RemoteDataSource
import com.example.core.data.source.remote.network.ApiResponse
import com.example.core.data.source.remote.response.ResultsItemFilm
import com.example.core.utils.AppExecutors
import com.example.core.domain.model.EntityItem
import com.example.core.domain.repository.IMovieRepository
import com.example.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class MovieRepository(private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource, private val appExecutors: AppExecutors):IMovieRepository{

    override fun getAllFilm(): Flow<Resource<List<EntityItem>>> =
        object : NetworkBoundResource<List<EntityItem>, List<ResultsItemFilm>>() {
            override fun loadFromDB(): Flow<List<EntityItem>> {
                return localDataSource.getAllFilm().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<EntityItem>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<ResultsItemFilm>>> =
                remoteDataSource.getAllFilm()

            override suspend fun saveCallResult(data: List<ResultsItemFilm>) {
                val filmList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertFilm(filmList)
            }
        }.asFlow()

    override fun getFavoriteFilm(): Flow<List<EntityItem>> {
        return localDataSource.getFavoriteFilm().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteFilm(film: EntityItem, state: Boolean) {
        val filmEntity = DataMapper.mapDomainToEntity(film)
        appExecutors.diskIO().execute { localDataSource.setFavoriteFilm(filmEntity, state) }
    }


}