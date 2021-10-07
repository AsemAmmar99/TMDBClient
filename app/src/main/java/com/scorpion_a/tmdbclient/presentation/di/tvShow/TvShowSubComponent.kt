package com.scorpion_a.tmdbclient.presentation.di.tvShow

import com.scorpion_a.tmdbclient.presentation.artist.ArtistActivity
import com.scorpion_a.tmdbclient.presentation.movie.MovieActivity
import com.scorpion_a.tmdbclient.presentation.tv.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface factory{
        fun create(): TvShowSubComponent
    }
}