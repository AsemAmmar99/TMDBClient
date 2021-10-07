package com.scorpion_a.tmdbclient.presentation.di.artist

import com.scorpion_a.tmdbclient.presentation.artist.ArtistActivity
import dagger.Subcomponent

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {
    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface factory{
        fun create(): ArtistSubComponent
    }
}