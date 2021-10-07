package com.scorpion_a.tmdbclient.data.repository.movie.datasource

import com.scorpion_a.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}