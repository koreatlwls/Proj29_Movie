package com.example.proj29_movie.domain.model

data class MovieReviews(
    val myReview: Review?,
    val othersReview: List<Review>
)