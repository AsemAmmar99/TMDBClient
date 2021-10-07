package com.scorpion_a.tmdbclient.data.repository.artist.datasource

import com.scorpion_a.tmdbclient.data.model.artist.ArtistList
import com.scorpion_a.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}