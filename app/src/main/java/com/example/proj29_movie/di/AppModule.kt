package com.example.proj29_movie.di

import android.app.Activity
import com.example.proj29_movie.data.api.*
import com.example.proj29_movie.data.preference.PreferenceManager
import com.example.proj29_movie.data.preference.SharedPreferenceManager
import com.example.proj29_movie.data.repository.*
import com.example.proj29_movie.domain.model.Movie
import com.example.proj29_movie.domain.usecase.*
import com.example.proj29_movie.presentation.home.HomeContract
import com.example.proj29_movie.presentation.home.HomeFragment
import com.example.proj29_movie.presentation.home.HomePresenter
import com.example.proj29_movie.presentation.mypage.MyPageContract
import com.example.proj29_movie.presentation.mypage.MyPageFragment
import com.example.proj29_movie.presentation.mypage.MyPagePresenter
import com.example.proj29_movie.presentation.reviews.MovieReviewsContract
import com.example.proj29_movie.presentation.reviews.MovieReviewsFragment
import com.example.proj29_movie.presentation.reviews.MovieReviewsPresenter
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single { Dispatchers.IO }
}

val dataModule = module {
    single { Firebase.firestore }

    single<MovieApi> { MovieFirestoreApi(get()) }
    single<ReviewApi> { ReviewFirestoreApi(get()) }
    single<UserApi> { UserFirestoreApi(get()) }

    single<MovieRepository> { MovieRepositoryImpl(get(), get()) }
    single<ReviewRepository> { ReviewRepositoryImpl(get(), get()) }
    single<UserRepository> { UserRepositoryImpl(get(), get(), get()) }

    single { androidContext().getSharedPreferences("preference", Activity.MODE_PRIVATE) }
    single<PreferenceManager> { SharedPreferenceManager(get()) }
}

val domainModule = module {
    factory { GetRandomFeaturedMovieUseCase(get(), get()) }
    factory { GetAllMoviesUseCase(get()) }
    factory { GetAllMovieReviewsUseCase(get(), get()) }
    factory { GetMyReviewedMoviesUseCase(get(), get(), get()) }
    factory { SubmitReviewUseCase(get(), get()) }
    factory { DeleteReviewUseCase(get()) }
}

val presenterModule = module {
    scope<HomeFragment> {
        scoped<HomeContract.Presenter> { HomePresenter(getSource(), get(), get()) }
    }
    scope<MovieReviewsFragment> {
        scoped<MovieReviewsContract.Presenter> { (movie: Movie) ->
            MovieReviewsPresenter(movie, getSource(), get(), get(), get())
        }
    }
    scope<MyPageFragment> {
        scoped<MyPageContract.Presenter> { MyPagePresenter(getSource(), get()) }
    }
}