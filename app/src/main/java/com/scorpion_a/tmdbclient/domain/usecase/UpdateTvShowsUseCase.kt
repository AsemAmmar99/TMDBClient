package com.scorpion_a.tmdbclient.domain.usecase

import com.scorpion_a.tmdbclient.data.model.tvshow.TvShow
import com.scorpion_a.tmdbclient.domain.repository.TvShowRepository

class UpdateTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute(): List<TvShow>? = tvShowRepository.updateTvShows()
}