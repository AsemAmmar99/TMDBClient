package com.scorpion_a.tmdbclient.data.repository.tvshow.datasourceImpl

import android.util.Log
import com.scorpion_a.tmdbclient.data.model.movie.Movie
import com.scorpion_a.tmdbclient.data.model.tvshow.TvShow
import com.scorpion_a.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.scorpion_a.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.scorpion_a.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.scorpion_a.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.scorpion_a.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.scorpion_a.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.scorpion_a.tmdbclient.domain.repository.MovieRepository
import com.scorpion_a.tmdbclient.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
): TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShows = getTvShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowsToCache(newListOfTvShows)

        return newListOfTvShows
    }

    suspend fun getTvShowsFromAPI(): List<TvShow>{
        lateinit var tvShowList: List<TvShow>
        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response.body()
            if (body!=null){
                tvShowList = body.tvShows
            }
        }catch (ex: Exception){
            Log.i("Tag", ex.message.toString())
        }

        return tvShowList
    }

    suspend fun getTvShowsFromDB(): List<TvShow>{
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDB()
        }catch (ex: Exception){
            Log.i("Tag", ex.message.toString())
        }
        if (tvShowList.isNotEmpty()){
            return tvShowList
        }else{
            tvShowList = getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
        }

        return tvShowList
    }

    suspend fun getTvShowsFromCache(): List<TvShow>{
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowCacheDataSource.getTvShowsFromCache()
        }catch (ex: Exception){
            Log.i("Tag", ex.message.toString())
        }
        if (tvShowList.isNotEmpty()){
            return tvShowList
        }else{
            tvShowList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
        }

        return tvShowList
    }
}