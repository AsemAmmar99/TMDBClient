package com.scorpion_a.tmdbclient.data.repository.artist.datasourceImpl

import android.util.Log
import com.scorpion_a.tmdbclient.data.model.artist.Artist
import com.scorpion_a.tmdbclient.data.model.movie.Movie
import com.scorpion_a.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.scorpion_a.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.scorpion_a.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.scorpion_a.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.scorpion_a.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.scorpion_a.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.scorpion_a.tmdbclient.domain.repository.ArtistRepository
import com.scorpion_a.tmdbclient.domain.repository.MovieRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
): ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtists)
        artistCacheDataSource.saveArtistsToCache(newListOfArtists)

        return newListOfArtists
    }

    suspend fun getArtistsFromAPI(): List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if (body!=null){
                artistList = body.artists
            }
        }catch (ex: Exception){
            Log.i("Tag", ex.message.toString())
        }

        return artistList
    }

    suspend fun getArtistsFromDB(): List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistsFromDB()
        }catch (ex: Exception){
            Log.i("Tag", ex.message.toString())
        }
        if (artistList.isNotEmpty()){
            return artistList
        }else{
            artistList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }

        return artistList
    }

    suspend fun getArtistsFromCache(): List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistsFromCache()
        }catch (ex: Exception){
            Log.i("Tag", ex.message.toString())
        }
        if (artistList.isNotEmpty()){
            return artistList
        }else{
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }

        return artistList
    }
}