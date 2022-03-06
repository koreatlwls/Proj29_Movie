package com.example.proj29_movie.domain.usecase

import com.example.proj29_movie.data.repository.ReviewRepository
import com.example.proj29_movie.data.repository.UserRepository
import com.example.proj29_movie.domain.model.Movie
import com.example.proj29_movie.domain.model.Review
import com.example.proj29_movie.domain.model.User

class SubmitReviewUseCase(
    private val userRepository: UserRepository,
    private val reviewRepository: ReviewRepository
) {

    suspend operator fun invoke(
        movie: Movie,
        content: String,
        score: Float
    ): Review {
        var user = userRepository.getUser()

        if (user == null) {
            userRepository.saveUser(User())
            user = userRepository.getUser()
        }

        return reviewRepository.addReview(
            Review(
                userId = user!!.id,
                movieId = movie.id,
                content = content,
                score = score
            )
        )
    }
}