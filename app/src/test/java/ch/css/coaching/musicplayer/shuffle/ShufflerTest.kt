package ch.css.coaching.musicplayer.shuffle

import ch.css.coaching.musicplayer.music.Genre
import ch.css.coaching.musicplayer.music.Mapper
import ch.css.coaching.musicplayer.music.Title
import ch.css.coaching.musicplayer.persistence.Repository
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ShufflerTest {

    private val title1: Title = Title(1, "AC/DC", "Highway to Hell", 200000, 0, Genre.HardRock)
    private val title2: Title = Title(2, "Bob Marley", "Buffalo Soldier", 200000, 0, Genre.Reggea)
    private val titles: MutableList<Title> = mutableListOf(title1, title2)

    @Test
    fun when_profileSetToReggea_then_nextTitleIsReggea() {

        val genre = Genre.Reggea

        val repository = mockk<Repository>()
        every { repository.getTitles() } returns titles

        val mapper = mockk<Mapper>()
        every { mapper.getGenres(any()) } returns mutableListOf(genre)

        val shuffler = Shuffler(repository, mapper)

        shuffler.setProfile(Profile("Chill"))
        assertEquals(genre, shuffler.nextTitle().getGenre())
    }

}
