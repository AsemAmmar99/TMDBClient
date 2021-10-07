package com.scorpion_a.tmdbclient.data.repository.artist.datasourceImpl

import com.scorpion_a.tmdbclient.data.api.TMDBService
import com.scorpion_a.tmdbclient.data.model.artist.ArtistList
import com.scorpion_a.tmdbclient.data.model.movie.MovieList
import com.scorpion_a.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.scorpion_a.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
    ): ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtists(apiKey)
}