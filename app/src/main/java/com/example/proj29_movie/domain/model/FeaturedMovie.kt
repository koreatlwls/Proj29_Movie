package com.example.proj29_movie.domain.model

data class FeaturedMovie(
    val movie: Movie,
    val latestReview: Review?
)