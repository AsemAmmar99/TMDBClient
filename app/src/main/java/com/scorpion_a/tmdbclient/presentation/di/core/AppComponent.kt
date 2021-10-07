package com.scorpion_a.tmdbclient.presentation.di.core

import com.scorpion_a.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.scorpion_a.tmdbclient.presentation.di.movie.MovieSubComponent
import com.scorpion_a.tmdbclient.presentation.di.tvShow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    DatabaseModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    RemoteDataModule::class,
    LocalDataModule::class,
    CacheDataModule::class
])
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.factory
    fun artistSubComponent(): ArtistSubComponent.factory
    fun tvShowSubComponent(): TvShowSubComponent.factory
}