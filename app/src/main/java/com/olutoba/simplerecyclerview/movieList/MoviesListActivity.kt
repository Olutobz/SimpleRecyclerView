package com.olutoba.simplerecyclerview.movieList

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.RecyclerView
import com.olutoba.simplerecyclerview.R
import com.olutoba.simplerecyclerview.addMovie.AddMovieActivity
import com.olutoba.simplerecyclerview.addMovie.FLOWER_NAME
import com.olutoba.simplerecyclerview.data.Movie
import com.olutoba.simplerecyclerview.movieDetail.MovieDetailActivity
import com.olutoba.simplerecyclerview.movieDetail.MovieDetailViewModel

const val MOVIE_ID = "movie id"

class MoviesListActivity : AppCompatActivity() {

    private val moviesListViewModel by viewModels<MoviesListViewModel> {
        MoviesListViewModelFactory(this)
    }

    private var launchAddMovieActivity =
        registerForActivityResult(StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // There are no request codes
                val data: Intent? = result.data
                val movieName = data?.getStringExtra(FLOWER_NAME)
                moviesListViewModel.addMovie(movieName)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val headerAdapter = HeaderAdapter()
        val movieAdapter = MovieAdapter { movie -> adapterOnClick(movie) }
        val concatAdapter = ConcatAdapter(headerAdapter, movieAdapter)

        val recyclerView: RecyclerView = findViewById(R.id.movie_list)
        recyclerView.adapter = concatAdapter

        moviesListViewModel.moviesLiveData.observe(this) { movies ->
            movies?.let {
                movieAdapter.submitList(movies as MutableList<Movie>)
                headerAdapter.updateMovieCount(movies.size)
            }
        }

        val fab: View = findViewById(R.id.fab)
        fab.setOnClickListener {
            fabOnClick()
        }

    }

    private fun adapterOnClick(movie: Movie) {
        val intent = Intent(this, MovieDetailActivity::class.java)
        intent.putExtra(MOVIE_ID, movie.id)
        startActivity(intent)
    }

    /* Adds movie to movieList when FAB is clicked. */
    private fun fabOnClick() {
        val intent = Intent(this, AddMovieActivity::class.java)
        launchAddMovieActivity.launch(intent)
    }
}