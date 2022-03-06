package com.example.proj29_movie.domain.usecase

import com.example.proj29_movie.data.repository.ReviewRepository
import com.example.proj29_movie.domain.model.Review

class DeleteReviewUseCase(
    private val reviewRepository: ReviewRepository
) {
    suspend operator fun invoke(review: Review) =
        reviewRepository.removeReview(review)
}