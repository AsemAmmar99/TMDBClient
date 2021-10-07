package com.scorpion_a.tmdbclient.presentation.di.artist

import com.scorpion_a.tmdbclient.domain.usecase.GetArtistsUseCase
import com.scorpion_a.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.scorpion_a.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory{
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }
}