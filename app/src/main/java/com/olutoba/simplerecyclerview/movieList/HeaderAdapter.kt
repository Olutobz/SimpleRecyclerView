package com.olutoba.simplerecyclerview.movieList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.olutoba.simplerecyclerview.R

class HeaderAdapter : RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>() {

    private var movieCount: Int = 0

    // ViewHolder for displaying header
    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val movieNumberTextView: TextView = itemView.findViewById(R.id.header_number_text)

        fun bind(movieCount: Int) {
            movieNumberTextView.text = movieCount.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.header_item, parent, false)
        return HeaderViewHolder(view)
    }

    /* Binds the number of movies to the header */
    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.bind(movieCount)
    }

    override fun getItemCount(): Int {
        return 1
    }

    /* Updates header to display number of movies when a movie is added or subtracted. */
    fun updateMovieCount(updatedMovieCount: Int) {
        movieCount = updatedMovieCount
        notifyDataSetChanged()
    }

}