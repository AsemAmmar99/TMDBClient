package com.scorpion_a.tmdbclient.data.repository.artist.datasource

import com.scorpion_a.tmdbclient.data.model.artist.Artist
import com.scorpion_a.tmdbclient.data.model.movie.Movie

interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache(): List<Artist>
    suspend fun saveArtistsToCache(artists: List<Artist>)
}