package com.scorpion_a.tmdbclient.presentation.movie



import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.scorpion_a.tmdbclient.data.model.movie.Movie
import com.scorpion_a.tmdbclient.domain.usecase.GetMoviesUseCase
import com.scorpion_a.tmdbclient.domain.usecase.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
): ViewModel() {

    fun getMovies() = liveData {

        val moviesList = getMoviesUseCase.execute()
        emit(moviesList)
    }

    fun updateMovies() = liveData {

        val moviesList = updateMoviesUseCase.execute()
        emit(moviesList)
    }

}