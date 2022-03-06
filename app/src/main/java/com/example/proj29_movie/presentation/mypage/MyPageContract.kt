package com.example.proj29_movie.presentation.mypage

import com.example.proj29_movie.domain.model.ReviewedMovie
import com.example.proj29_movie.presentation.BasePresenter
import com.example.proj29_movie.presentation.BaseView

interface MyPageContract {

    interface View : BaseView<Presenter> {

        fun showLoadingIndicator()

        fun hideLoadingIndicator()

        fun showNoDataDescription(message: String)

        fun showErrorDescription(message: String)

        fun showReviewedMovies(reviewedMovies: List<ReviewedMovie>)
    }

    interface Presenter : BasePresenter
}