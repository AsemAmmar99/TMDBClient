package com.scorpion_a.tmdbclient.presentation

import android.app.Application
import com.scorpion_a.tmdbclient.BuildConfig
import com.scorpion_a.tmdbclient.presentation.di.Injector
import com.scorpion_a.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.scorpion_a.tmdbclient.presentation.di.core.*
import com.scorpion_a.tmdbclient.presentation.di.movie.MovieSubComponent
import com.scorpion_a.tmdbclient.presentation.di.tvShow.TvShowSubComponent
import dagger.internal.DaggerCollections


class App: Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule("https://api.themoviedb.org/3/"))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()

    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

}