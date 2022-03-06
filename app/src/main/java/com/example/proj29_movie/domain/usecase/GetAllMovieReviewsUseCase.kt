package com.example.proj29_movie.domain.usecase

import com.example.proj29_movie.data.repository.ReviewRepository
import com.example.proj29_movie.data.repository.UserRepository
import com.example.proj29_movie.domain.model.MovieReviews
import com.example.proj29_movie.domain.model.User

class GetAllMovieReviewsUseCase(
    private val userRepository: UserRepository,
    private val reviewRepository: ReviewRepository
) {

    suspend operator fun invoke(movieId: String): MovieReviews {
        val reviews = reviewRepository.getAllMovieReviews(movieId)
        val user = userRepository.getUser()

        if (user == null) {
            userRepository.saveUser(User())

            return MovieReviews(null, reviews)
        }

        return MovieReviews(
            reviews.find { it.userId == user.id },
            reviews.filter { it.userId != user.id }
        )
    }
}