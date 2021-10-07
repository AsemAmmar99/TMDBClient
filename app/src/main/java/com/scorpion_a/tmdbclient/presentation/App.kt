package com.scorpion_a.tmdbclient.presentation

import android.app.Application
import com.scorpion_a.tmdbclient.presentation.di.Injector
import com.scorpion_a.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.scorpion_a.tmdbclient.presentation.di.core.AppComponent
import com.scorpion_a.tmdbclient.presentation.di.movie.MovieSubComponent
import com.scorpion_a.tmdbclient.presentation.di.tvShow.TvShowSubComponent
import dagger.internal.DaggerCollections


class App: Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        TODO("Not yet implemented")
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        TODO("Not yet implemented")
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        TODO("Not yet implemented")
    }

}