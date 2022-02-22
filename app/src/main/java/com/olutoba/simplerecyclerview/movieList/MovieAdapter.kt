package com.olutoba.simplerecyclerview.movieList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.olutoba.simplerecyclerview.R
import com.olutoba.simplerecyclerview.data.Movie

class MovieAdapter(private val onClick: (Movie) -> Unit) :
    ListAdapter<Movie, MovieAdapter.MovieViewHolder>(MovieDiffCallback) {

    /* ViewHolder for Movie, takes in the inflated view and the onClick behavior.  */
    class MovieViewHolder(itemView: View, val onClick: (Movie) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private val movieTextView: TextView = itemView.findViewById(R.id.movie_text)
        private val movieImageView: ImageView = itemView.findViewById(R.id.movie_image)
        private var currentMovie: Movie? = null

        init {
            itemView.setOnClickListener {
                currentMovie?.let {
                    onClick(it)
                }
            }
        }

        /* Bind movie name and image */
        fun bind(movie: Movie) {
            currentMovie = movie
            movieTextView.text = currentMovie!!.name
            if (currentMovie != null) {
                movieImageView.setImageResource(currentMovie!!.image)
            } else {
                movieImageView.setImageResource(R.drawable.aeon_flux)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(view, onClick)
    }

    /* Gets the current movie and uses it to bind view. */
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
    }

    object MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }
    }

}