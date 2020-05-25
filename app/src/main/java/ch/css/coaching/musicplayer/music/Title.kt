package ch.css.coaching.musicplayer.music

class Title(
    private val id: Int,
    private val artist: String,
    private val title: String,
    private val length: Int,
    private val albumArt: Int,
    private val genre: Genre
) {
    fun getId(): Int {
        return id
    }

    fun getAlbumArt(): Int {
        return albumArt
    }

    fun getLength(): Int {
        return length
    }

    fun getTitle(): String {
        return title
    }

    fun getArtist(): String {
        return artist
    }

    fun getGenre(): Genre {
        return this.genre
    }
}