package com.example.proj29_movie.data.preference

import android.content.SharedPreferences
import androidx.core.content.edit

class SharedPreferenceManager(
    private val sharedPreferences: SharedPreferences
) : PreferenceManager {

    override fun getString(key: String): String? =
        sharedPreferences.getString(key, null)

    override fun putString(key: String, value: String) =
        sharedPreferences.edit { putString(key, value) }
}