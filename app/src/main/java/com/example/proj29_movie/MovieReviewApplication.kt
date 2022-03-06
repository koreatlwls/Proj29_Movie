package com.example.proj29_movie

import android.app.Application
import com.example.proj29_movie.di.appModule
import com.example.proj29_movie.di.dataModule
import com.example.proj29_movie.di.domainModule
import com.example.proj29_movie.di.presenterModule
import com.example.proj29_movie.utility.MovieDataGenerator
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MovieReviewApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@MovieReviewApplication)
            modules(appModule+ dataModule+ domainModule+ presenterModule)
        }

        //MovieDataGenerator().generate()
    }
}