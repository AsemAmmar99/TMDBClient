package com.scorpion_a.tmdbclient.data.repository.movie.datasource

import com.scorpion_a.tmdbclient.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}