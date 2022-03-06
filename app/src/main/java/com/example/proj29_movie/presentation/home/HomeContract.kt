package com.example.proj29_movie.presentation.home

import com.example.proj29_movie.domain.model.FeaturedMovie
import com.example.proj29_movie.domain.model.Movie
import com.example.proj29_movie.presentation.BasePresenter
import com.example.proj29_movie.presentation.BaseView

interface HomeContract {

    interface View : BaseView<Presenter> {

        fun showLoadingIndicator()

        fun hideLoadingIndicator()

        fun showErrorDescription(message: String)

        fun showMovies(
            featuredMovie : FeaturedMovie?,
            movies: List<Movie>
        )
    }

    interface Presenter : BasePresenter
}