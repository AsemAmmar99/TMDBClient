package com.scorpion_a.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.scorpion_a.tmdbclient.domain.usecase.GetArtistsUseCase
import com.scorpion_a.tmdbclient.domain.usecase.GetMoviesUseCase
import com.scorpion_a.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.scorpion_a.tmdbclient.domain.usecase.UpdateMoviesUseCase

class ArtistViewModelFactory(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistsUseCase, updateArtistsUseCase) as T
    }

}