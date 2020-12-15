package com.mokhtarradreza.movie.presentation.search

import com.mokhtarradreza.movie.domain.model.MovieShort

sealed class SearchState {

    class SuccessState(val movies: List<MovieShort>) : SearchState()

    object ErrorState: SearchState()

    object LoadingState: SearchState()
}
