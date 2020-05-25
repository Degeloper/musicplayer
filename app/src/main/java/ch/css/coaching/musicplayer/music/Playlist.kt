package ch.css.coaching.musicplayer.music

class Playlist {

    private val titles: MutableList<Title> = mutableListOf()

    fun addTitle(title: Title) {
        titles.add(title)
    }

    fun getTitles(): MutableList<Title> {
        return titles
    }
}