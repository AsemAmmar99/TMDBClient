package com.scorpion_a.tmdbclient.data.model.artist


import com.google.gson.annotations.SerializedName
import com.scorpion_a.tmdbclient.data.model.artist.Artist

data class ArtistList(
    @SerializedName("results")
    val artists: List<Artist>,
)