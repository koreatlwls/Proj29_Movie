package com.example.proj29_movie.domain.usecase

import com.example.proj29_movie.data.repository.MovieRepository
import com.example.proj29_movie.domain.model.Movie

class GetAllMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend operator fun invoke(): List<Movie> = movieRepository.getAllMovies()
}