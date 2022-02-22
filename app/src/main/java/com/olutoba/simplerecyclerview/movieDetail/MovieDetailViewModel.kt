package com.olutoba.simplerecyclerview.movieDetail

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.olutoba.simplerecyclerview.data.Datasource
import com.olutoba.simplerecyclerview.data.Movie

class MovieDetailViewModel(private val datasource: Datasource) : ViewModel() {

    /* Queries datasource to returns a movie that corresponds to an id. */
    fun getMovieForId(id: Long): Movie? {
        return datasource.getMovieForId(id)
    }

    /* Queries datasource to remove a movie. */
    fun removeMovie(movie: Movie) {
        datasource.removeMovie(movie)
    }

}

@Suppress("UNCHECKED_CAST")
class MovieDetailViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieDetailViewModel::class.java)) {
            return MovieDetailViewModel(
                datasource = Datasource.getDataSource(context.resources)
            ) as T
        } else throw IllegalArgumentException("Unknown ViewModel class")
    }

}