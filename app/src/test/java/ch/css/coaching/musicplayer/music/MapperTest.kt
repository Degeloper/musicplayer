package ch.css.coaching.musicplayer.music

import ch.css.coaching.musicplayer.shuffle.Profile
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MapperTest {

    @Test
    fun when_add1Profile_then_getTheProfile() {
        val cut = Mapper()
        val profile = Profile("Feelgood")
        val genre = Genre.Reggea
        cut.insert(profile, genre)
        assertEquals(genre, cut.getGenres(profile)?.get(0))
    }

    @Test
    fun when_add2GenresWithSameProfile_then_get2Genres() {
        val cut = Mapper()
        val profile = Profile("Feelgood")
        cut.insert(profile, Genre.Reggea)
        cut.insert(profile, Genre.Country)
        assertEquals(2, cut.getGenres(profile)?.size)
    }

    @Test
    fun when_add2xSameGenreWithSameProfile_then_get1Genres() {
        val cut = Mapper()
        val profile = Profile("Feelgood")
        cut.insert(profile, Genre.Reggea)
        cut.insert(profile, Genre.Reggea)
        assertEquals(1, cut.getGenres(profile)?.size)
    }
}