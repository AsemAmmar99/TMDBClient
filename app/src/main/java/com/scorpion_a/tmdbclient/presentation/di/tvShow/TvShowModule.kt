package com.scorpion_a.tmdbclient.presentation.di.tvShow

import com.scorpion_a.tmdbclient.domain.usecase.*
import com.scorpion_a.tmdbclient.presentation.artist.ArtistViewModelFactory
import com.scorpion_a.tmdbclient.presentation.di.artist.ArtistScope
import com.scorpion_a.tmdbclient.presentation.movie.MovieViewModelFactory
import com.scorpion_a.tmdbclient.presentation.tv.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }
}