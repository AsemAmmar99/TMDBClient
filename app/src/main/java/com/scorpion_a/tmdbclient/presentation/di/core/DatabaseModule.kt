package com.scorpion_a.tmdbclient.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.scorpion_a.tmdbclient.data.db.ArtistDao
import com.scorpion_a.tmdbclient.data.db.MovieDao
import com.scorpion_a.tmdbclient.data.db.TMDBDatabase
import com.scorpion_a.tmdbclient.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context): TMDBDatabase{
       return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient")
           .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao{
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase): TvShowDao{
        return tmdbDatabase.tvShowDao()
    }
    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDao{
        return tmdbDatabase.artistDao()
    }
}