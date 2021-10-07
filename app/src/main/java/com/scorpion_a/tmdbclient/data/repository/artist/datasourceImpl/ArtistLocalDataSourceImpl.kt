package com.scorpion_a.tmdbclient.data.repository.artist.datasourceImpl

import com.scorpion_a.tmdbclient.data.db.ArtistDao
import com.scorpion_a.tmdbclient.data.db.MovieDao
import com.scorpion_a.tmdbclient.data.model.artist.Artist
import com.scorpion_a.tmdbclient.data.model.movie.Movie
import com.scorpion_a.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.scorpion_a.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao): ArtistLocalDataSource {
    override suspend fun getArtistsFromDB(): List<Artist> {
       return artistDao.getArtists()
    }

    override suspend fun saveArtistsToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }
}