package com.scorpion_a.tmdbclient.domain.usecase

import com.scorpion_a.tmdbclient.data.model.artist.Artist
import com.scorpion_a.tmdbclient.domain.repository.ArtistRepository


class GetArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.getArtists()
}