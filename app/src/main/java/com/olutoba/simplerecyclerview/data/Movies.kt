package com.olutoba.simplerecyclerview.data

import android.content.res.Resources
import com.olutoba.simplerecyclerview.R

// Returns initial list of movies
fun movieList(res: Resources): List<Movie> {
    return listOf(
        Movie(
            id = 1,
            name = res.getString(R.string.movie1_name),
            image = R.drawable.the_tomorrow_war,
        ),
        Movie(
            id = 2,
            name = res.getString(R.string.movie2_name),
            image = R.drawable.encounter
        ),
        Movie(
            id = 3,
            name = res.getString(R.string.movie3_name),
            image = R.drawable.cinderella_image
        ),
        Movie(
            id = 4,
            name = res.getString(R.string.movie4_name),
            image = R.drawable.without_remorse
        ),
        Movie(
            id = 5,
            name = res.getString(R.string.movie5_name),
            image = R.drawable.wildling
        ),
        Movie(
            id = 6,
            name = res.getString(R.string.movie6_name),
            image = R.drawable.bliss
        ),
        Movie(
            id = 7,
            name = res.getString(R.string.movie7_name),
            image = R.drawable.sister_bliss
        ),
        Movie(
            id = 8,
            name = res.getString(R.string.movie8_name),
            image = R.drawable.aeon_flux
        ),
        Movie(
            id = 9,
            name = res.getString(R.string.movie9_name),
            image = R.drawable.spencer
        ),
        Movie(
            id = 10,
            name = res.getString(R.string.movie10_name),
            image = R.drawable.a_fall_from_grace
        ),
        Movie(
            id = 11,
            name = res.getString(R.string.movie11_name),
            image = R.drawable.nancy_drew_and_the_hidden_staircase
        ),
        Movie(
            id = 12,
            name = res.getString(R.string.movie12_name),
            image = R.drawable.security
        ),
        Movie(
            id = 13,
            name = res.getString(R.string.movie13_name),
            image = R.drawable.till_death
        ),
        Movie(
            id = 14,
            name = res.getString(R.string.movie14_name),
            image = R.drawable.intrusion
        ),
        Movie(
            id = 15,
            name = res.getString(R.string.movie10_name),
            image = R.drawable.initiation
        ),
        Movie(
            id = 16,
            name = res.getString(R.string.movie16_name),
            image = R.drawable.the_tender_bar
        ),
        Movie(
            id = 17,
            name = res.getString(R.string.movie17_name),
            image = R.drawable.coming_to_america
        ),
        Movie(
            id = 18,
            name = res.getString(R.string.movie18_name),
            image = R.drawable.disney_encanto
        ),
        Movie(
            id = 19,
            name = res.getString(R.string.movie19_name),
            image = R.drawable.music
        ),
        Movie(
            id = 20,
            name = res.getString(R.string.movie20_name),
            image = R.drawable.rumble
        ),
        Movie(
            id = 21,
            name = res.getString(R.string.movie21_name),
            image = R.drawable.shadow_in_the_cloud
        ),
        Movie(
            id = 22,
            name = res.getString(R.string.movie22_name),
            image = R.drawable.the_water_man
        )
    )
}