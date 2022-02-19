package com.olutoba.simplerecyclerview.data

import android.content.Context
import com.olutoba.simplerecyclerview.R

class Datasource(private val context: Context) {

    fun getMovieList(): Array<String> {
        return context.resources.getStringArray(R.array.movie_array)
    }
}