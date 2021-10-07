package com.scorpion_a.tmdbclient.presentation.di.movie

import com.scorpion_a.tmdbclient.presentation.artist.ArtistActivity
import com.scorpion_a.tmdbclient.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface factory{
        fun create(): MovieSubComponent
    }
}