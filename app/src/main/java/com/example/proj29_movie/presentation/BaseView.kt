package com.example.proj29_movie.presentation

interface BaseView<PresenterT : BasePresenter> {

    val presenter: PresenterT
}