package com.olutoba.simplerecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.olutoba.simplerecyclerview.adapter.MovieTitleAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val movieList = Datasource(this).getMovieList()
        val recyclerView: RecyclerView = findViewById(R.id.movie_list)
        recyclerView.adapter = MovieTitleAdapter(movieList)
    }
}