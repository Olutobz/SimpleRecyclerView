package com.olutoba.simplerecyclerview.addMovie

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.olutoba.simplerecyclerview.R

const val FLOWER_NAME = "name"

class AddMovieActivity : AppCompatActivity() {

    private lateinit var addMovieName: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movie)

        findViewById<Button>(R.id.done_button).setOnClickListener {
            addMovie()
        }
        addMovieName = findViewById(R.id.add_flower_name)
    }

    private fun addMovie() {
        val resultIntent = Intent()

        if (addMovieName.text.isNullOrEmpty()) {
            setResult(Activity.RESULT_CANCELED, resultIntent)
        } else {
            val name = addMovieName.text.toString()
            resultIntent.putExtra(FLOWER_NAME, name)
            setResult(Activity.RESULT_OK, resultIntent)
        }
        finish()
    }
}