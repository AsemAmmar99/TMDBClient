package com.scorpion_a.tmdbclient.data.repository.tvshow.datasourceImpl

import com.scorpion_a.tmdbclient.data.api.TMDBService
import com.scorpion_a.tmdbclient.data.model.movie.MovieList
import com.scorpion_a.tmdbclient.data.model.tvshow.TvShowList
import com.scorpion_a.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.scorpion_a.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
    ): TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)
}