package com.scorpion_a.tmdbclient.data.repository.tvshow.datasource

import com.scorpion_a.tmdbclient.data.model.movie.MovieList
import com.scorpion_a.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}