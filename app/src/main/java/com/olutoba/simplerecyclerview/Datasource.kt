package com.olutoba.simplerecyclerview

import android.content.Context

class Datasource(private val context: Context) {

    fun getMovieList(): Array<String> {
        return context.resources.getStringArray(R.array.movie_array)
    }
}