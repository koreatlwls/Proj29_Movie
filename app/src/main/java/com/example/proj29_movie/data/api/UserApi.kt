package com.example.proj29_movie.data.api

import com.example.proj29_movie.domain.model.User

interface UserApi {

    suspend fun saveUser(user: User): User
}