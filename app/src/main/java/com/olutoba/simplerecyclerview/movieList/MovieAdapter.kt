package com.olutoba.simplerecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.olutoba.simplerecyclerview.R
import com.olutoba.simplerecyclerview.data.Movie

class MovieAdapter(private val movieList: Array<String>) :
    ListAdapter<Movie, MovieAdapter.MovieViewHolder>(MovieDiffCallback) {

    object MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val word = movieList[position]
        holder.bind(word)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    // Describes an item view and its place within the RecyclerView
    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val movieTextView: TextView = itemView.findViewById(R.id.movie_text)
        fun bind(word: String) {
            movieTextView.text = word
        }
    }

}