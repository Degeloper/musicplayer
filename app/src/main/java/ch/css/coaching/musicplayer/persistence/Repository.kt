package ch.css.coaching.musicplayer.persistence

import ch.css.coaching.musicplayer.R
import ch.css.coaching.musicplayer.music.Genre
import ch.css.coaching.musicplayer.music.Title

class Repository {
    fun getTitles(): MutableList<Title> {
        return mutableListOf(
            Title(R.raw.ac_dc, "AC/DC", "Back in Black", 257000, R.drawable.ac_dc, Genre.HardRock),
            Title(
                R.raw.jonny_cash,
                "Johnny Cash",
                "Get Rythm",
                135000,
                R.drawable.johnny_cash,
                Genre.Country
            ),
            Title(
                R.raw.bob_marley,
                "Bob Marley",
                "Buffalo Soldier",
                258000,
                R.drawable.bob_marley,
                Genre.Reggea
            )
        )
    }
}