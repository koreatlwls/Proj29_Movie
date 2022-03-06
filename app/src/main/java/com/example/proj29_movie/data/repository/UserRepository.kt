package com.example.proj29_movie.data.repository

import com.example.proj29_movie.domain.model.User

interface UserRepository {

    suspend fun getUser(): User?

    suspend fun saveUser(user: User)
}