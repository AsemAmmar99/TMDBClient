package com.scorpion_a.tmdbclient.presentation.di.movie

import com.scorpion_a.tmdbclient.domain.usecase.GetArtistsUseCase
import com.scorpion_a.tmdbclient.domain.usecase.GetMoviesUseCase
import com.scorpion_a.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.scorpion_a.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.scorpion_a.tmdbclient.presentation.artist.ArtistViewModelFactory
import com.scorpion_a.tmdbclient.presentation.di.artist.ArtistScope
import com.scorpion_a.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}