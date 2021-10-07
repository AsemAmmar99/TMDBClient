package com.scorpion_a.tmdbclient.data.model.tvshow


import com.google.gson.annotations.SerializedName
import com.scorpion_a.tmdbclient.data.model.tvshow.TvShow

data class TvShowList(
    @SerializedName("results")
    val tvShows: List<TvShow>,
)