package com.scorpion_a.tmdbclient.data.repository.movie.datasourceImpl

import android.util.Log
import com.scorpion_a.tmdbclient.data.model.movie.Movie
import com.scorpion_a.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.scorpion_a.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.scorpion_a.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.scorpion_a.tmdbclient.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
): MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)

        return newListOfMovies
    }

    suspend fun getMoviesFromAPI(): List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body!=null){
                movieList = body.movies
            }
        }catch (ex: Exception){
            Log.i("Tag", ex.message.toString())
        }

        return movieList
    }

    suspend fun getMoviesFromDB(): List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        }catch (ex: Exception){
            Log.i("Tag", ex.message.toString())
        }
        if (movieList.isNotEmpty()){
            return movieList
        }else{
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }

        return movieList
    }

    suspend fun getMoviesFromCache(): List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        }catch (ex: Exception){
            Log.i("Tag", ex.message.toString())
        }
        if (movieList.isNotEmpty()){
            return movieList
        }else{
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }

        return movieList
    }
}