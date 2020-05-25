package ch.css.coaching.musicplayer.shuffle

import ch.css.coaching.musicplayer.music.Mapper
import ch.css.coaching.musicplayer.music.Title
import ch.css.coaching.musicplayer.persistence.Repository

class Shuffler(
    private var repository: Repository,
    private var mapper: Mapper
) {
    private var profile: Profile? = Profile("All")

    fun setProfile(profile: Profile) {
        this.profile = profile
    }

    fun nextTitle(): Title {
        val genres = mapper.getGenres(this.profile!!)
        if (genres != null) {
            return repository.getTitles()
                .filter { title: Title -> genres.contains(title.getGenre()) }.random()
        }
        return repository.getTitles().random()
    }

}