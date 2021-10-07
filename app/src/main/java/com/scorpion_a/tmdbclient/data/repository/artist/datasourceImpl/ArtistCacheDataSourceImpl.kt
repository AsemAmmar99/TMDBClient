package com.scorpion_a.tmdbclient.data.repository.artist.datasourceImpl

import com.scorpion_a.tmdbclient.data.model.artist.Artist
import com.scorpion_a.tmdbclient.data.model.movie.Movie
import com.scorpion_a.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.scorpion_a.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource

class ArtistCacheDataSourceImpl: ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()
    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }

}