package com.olutoba.simplerecyclerview.data

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class Datasource(resources: Resources) {

    private val initialMovieList = movieList(resources)
    private val movieLiveData = MutableLiveData(initialMovieList)

    fun getMovieList(): LiveData<List<Movie>> {
        return movieLiveData
    }

    /* Returns a movie given an ID */
    fun getMovieForId(id: Long): Movie? {
        movieLiveData.value?.let { movies ->
            movies.firstOrNull { it.id == id }
        }
        return null
    }

    /* Returns a random movie asset for movies that are added. */
    fun getRandomMovieImageAsset(): Int {
        val randomNumber = initialMovieList.indices.random()
        return initialMovieList[randomNumber].image
    }

    /* Adds movie to liveData and posts value */
    fun addMovie(movie: Movie) {
        val currentList = movieLiveData.value
        if (currentList == null) {
            movieLiveData.postValue(listOf(movie))
        } else {
            val updatedList = currentList.toMutableList()
            updatedList.add(0, movie)
            movieLiveData.postValue(updatedList)
        }
    }

    /* Removes movie from liveData and posts a value */
    fun removeMovie(movie: Movie) {
        val currentList = movieLiveData.value
        if (currentList != null) {
            val updatedList = currentList.toMutableList()
            updatedList.remove(movie)
            movieLiveData.postValue(updatedList)
        } else {
            throw NoSuchElementException()
        }
    }

    companion object DataSource {
        private var INSTANCE: Datasource? = null

        fun getDataSource(resources: Resources): Datasource {
            return synchronized(DataSource::class) {
                val newInstance = INSTANCE ?: Datasource(resources)
                INSTANCE = newInstance
                newInstance
            }
        }
    }
}