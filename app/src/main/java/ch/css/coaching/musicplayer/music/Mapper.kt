package ch.css.coaching.musicplayer.music

import ch.css.coaching.musicplayer.shuffle.Profile

class Mapper {

    private val map: MutableMap<Profile, MutableList<Genre>> = mutableMapOf()

    fun insert(key: Profile, value: Genre) {
        if (!map.keys.contains(key)) {
            map[key] = mutableListOf()
        }

        if (!map[key]?.contains(value)!!) {
            map[key]?.add(value)
        }
    }

    fun getGenres(profile: Profile): MutableList<Genre>? {
        return map[profile]
    }

}