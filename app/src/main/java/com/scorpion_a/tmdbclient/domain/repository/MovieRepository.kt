package com.scorpion_a.tmdbclient.domain.repository

import com.scorpion_a.tmdbclient.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}