package com.olutoba.simplerecyclerview.movieDetail

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.olutoba.simplerecyclerview.R
import com.olutoba.simplerecyclerview.movieList.MOVIE_ID

class MovieDetailActivity : AppCompatActivity() {

    private val movieDetailViewModel by viewModels<MovieDetailViewModel> {
        MovieDetailViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        var currentMovieId: Long? = null

        val movieName: TextView = findViewById(R.id.movie_detail_name)
        val movieImage: ImageView = findViewById(R.id.movie_detail_image)
        val removeMovieButton: Button = findViewById(R.id.remove_button)

        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            currentMovieId = bundle.getLong(MOVIE_ID)
        }

        /* If currentFlowerId is not null, get corresponding flower and set name, image and
       description */
        currentMovieId?.let {
            val currentMovie = movieDetailViewModel.getMovieForId(it)
            movieName.text = currentMovie?.name
            if (currentMovie?.image == null) {
                if (currentMovie != null) {
                    movieImage.setImageResource(currentMovie.image)
                }
            } else {
                movieImage.setImageResource(currentMovie.image)
            }

            removeMovieButton.setOnClickListener {
                if (currentMovie != null) {
                    movieDetailViewModel.removeMovie(currentMovie)
                }
                finish()
            }

        }

    }
}