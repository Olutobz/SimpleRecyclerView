package com.olutoba.simplerecyclerview.data

import androidx.annotation.DrawableRes

data class Movie(
    val id: Long,
    val name: String,
    @DrawableRes
    val image: Int,
)