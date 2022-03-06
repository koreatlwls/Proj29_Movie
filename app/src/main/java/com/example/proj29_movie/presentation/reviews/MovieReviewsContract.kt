package com.example.proj29_movie.presentation.reviews

import com.example.proj29_movie.domain.model.Movie
import com.example.proj29_movie.domain.model.MovieReviews
import com.example.proj29_movie.domain.model.Review
import com.example.proj29_movie.presentation.BasePresenter
import com.example.proj29_movie.presentation.BaseView

interface MovieReviewsContract {

    interface View : BaseView<Presenter> {

        fun showLoadingIndicator()

        fun hideLoadingIndicator()

        fun showErrorDescription(message: String)

        fun showMovieInformation(movie: Movie)

        fun showReviews(reviews: MovieReviews)

        fun showErrorToast(message: String)
    }

    interface Presenter : BasePresenter {

        val movie: Movie

        fun requestAddReview(content: String, score: Float)

        fun requestRemoveReview(review: Review)
    }
}