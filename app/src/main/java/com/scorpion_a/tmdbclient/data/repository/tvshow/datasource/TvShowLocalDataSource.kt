package com.scorpion_a.tmdbclient.data.repository.tvshow.datasource

import com.scorpion_a.tmdbclient.data.model.movie.Movie
import com.scorpion_a.tmdbclient.data.model.tvshow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDB(): List<TvShow>
    suspend fun saveTvShowsToDB(tvShows: List<TvShow>)
    suspend fun clearAll()
}