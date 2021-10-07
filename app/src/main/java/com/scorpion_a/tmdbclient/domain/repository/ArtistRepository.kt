package com.scorpion_a.tmdbclient.domain.repository

import com.scorpion_a.tmdbclient.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?
}