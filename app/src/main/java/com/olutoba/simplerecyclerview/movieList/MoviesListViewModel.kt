package com.olutoba.simplerecyclerview.movieList

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.olutoba.simplerecyclerview.data.Datasource
import com.olutoba.simplerecyclerview.data.Movie
import kotlin.random.Random

class MoviesListViewModel(private val datasource: Datasource) : ViewModel() {

    val moviesLiveData = datasource.getMovieList()

    fun addMovie(movieName: String?) {
        if (movieName == null) {
            return
        }
        val image = datasource.getRandomMovieImageAsset()
        val newMovie = Movie(Random.nextLong(), movieName, image)
        datasource.addMovie(newMovie)
    }
}

@Suppress("UNCHECKED_CAST")
class MoviesListViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MoviesListViewModel::class.java)) {
            return MoviesListViewModel(
                datasource = Datasource.getDataSource(context.resources)
            ) as T
        } else throw IllegalArgumentException("Unknown ViewModel class")
    }

}