package com.olutoba.simplerecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.olutoba.simplerecyclerview.R

class MovieTitleAdapter(private val movieList: Array<String>) :
    RecyclerView.Adapter<MovieTitleAdapter.MovieTitleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieTitleViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MovieTitleViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieTitleViewHolder, position: Int) {
        val word = movieList[position]
        holder.bind(word)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    // Describes an item view and its place within the RecyclerView
    class MovieTitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val movieTextView: TextView = itemView.findViewById(R.id.movie_text)
        fun bind(word: String) {
            movieTextView.text = word
        }
    }

}