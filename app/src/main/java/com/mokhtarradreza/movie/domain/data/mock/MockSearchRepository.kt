package com.mokhtarradreza.movie.domain.data.mock

import com.mokhtarradreza.movie.domain.model.MovieShort
import com.mokhtarradreza.movie.domain.repository.SearchRepository

class MockSearchRepository : SearchRepository {

    override suspend fun searchMovie(search: String) : List<MovieShort> {
        return listOf(
            MovieShort("1", "Titre 1", "https://avatars1.githubusercontent.com/u/26967236?s=460&u=305e04783126372fe3a0e49d69ea3401b0f92dfe&v=4"),
            MovieShort("2", "Titre 2", "https://avatars1.githubusercontent.com/u/26967236?s=460&u=305e04783126372fe3a0e49d69ea3401b0f92dfe&v=4"),
            MovieShort("3", "Titre 3", "https://avatars1.githubusercontent.com/u/26967236?s=460&u=305e04783126372fe3a0e49d69ea3401b0f92dfe&v=4"),
            MovieShort("4", "Titre 4", "https://avatars1.githubusercontent.com/u/26967236?s=460&u=305e04783126372fe3a0e49d69ea3401b0f92dfe&v=4")
        )
    }

}