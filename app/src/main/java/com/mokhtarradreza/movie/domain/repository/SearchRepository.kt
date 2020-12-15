package com.mokhtarradreza.movie.domain.repository

import com.mokhtarradreza.movie.domain.model.MovieShort

interface SearchRepository {

    suspend fun searchMovie(search: String) : List<MovieShort>


}