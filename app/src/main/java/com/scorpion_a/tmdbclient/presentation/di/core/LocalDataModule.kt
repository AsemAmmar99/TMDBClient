package com.scorpion_a.tmdbclient.presentation.di.core

import com.scorpion_a.tmdbclient.data.db.ArtistDao
import com.scorpion_a.tmdbclient.data.db.MovieDao
import com.scorpion_a.tmdbclient.data.db.TvShowDao
import com.scorpion_a.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.scorpion_a.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.scorpion_a.tmdbclient.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.scorpion_a.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.scorpion_a.tmdbclient.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.scorpion_a.tmdbclient.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.scorpion_a.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.scorpion_a.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }
}