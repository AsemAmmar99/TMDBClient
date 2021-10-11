package com.scorpion_a.tmdbclient.presentation.tv



import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.scorpion_a.tmdbclient.domain.usecase.GetArtistsUseCase
import com.scorpion_a.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.scorpion_a.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.scorpion_a.tmdbclient.domain.usecase.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
): ViewModel() {

    fun getTvShows() = liveData {

        val tvShowsList = getTvShowsUseCase.execute()
        emit(tvShowsList)
    }

    fun updateTvShows() = liveData {

        val tvShowsList = updateTvShowsUseCase.execute()
        emit(tvShowsList)
    }

}