package ch.css.coaching.musicplayer.music

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PlaylistUnitTest {

    @Test
    fun when_addTitle_then_getTitlesContainsIt() {
        val title = Title(1, "AC/DC", "Highway to Hell", 200000, 0, Genre.HardRock)
        val playlist = Playlist()
        playlist.addTitle(title)
        assertEquals(playlist.getTitles()[0], title)
    }

    @Test
    fun when_add2Titles_then_getTitlesContains2() {
        val title1 = Title(1, "AC/DC", "Highway to Hell", 200000, 0, Genre.HardRock)
        val playlist = Playlist()
        playlist.addTitle(title1)
        val title2 = Title(2, "Bob Marley", "Buffalo Soldier", 200000, 0, Genre.Reggea)
        playlist.addTitle(title2)
        assertEquals(playlist.getTitles().size, 2)
    }
}
