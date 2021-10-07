package com.scorpion_a.tmdbclient.presentation.di

import com.scorpion_a.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.scorpion_a.tmdbclient.presentation.di.core.AppComponent
import com.scorpion_a.tmdbclient.presentation.di.movie.MovieSubComponent
import com.scorpion_a.tmdbclient.presentation.di.tvShow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
}