package com.scorpion_a.tmdbclient.presentation.di.core

import com.scorpion_a.tmdbclient.data.api.TMDBService
import com.scorpion_a.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.scorpion_a.tmdbclient.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.scorpion_a.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.scorpion_a.tmdbclient.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.scorpion_a.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.scorpion_a.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

}