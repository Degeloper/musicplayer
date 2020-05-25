package ch.css.coaching.musicplayer.player

import android.media.MediaPlayer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ch.css.coaching.musicplayer.music.Title
import ch.css.coaching.musicplayer.shuffle.Shuffler

class PlayerViewModel : ViewModel() {

    private var shuffler: Shuffler? = null
    private var musicPlayer: MediaPlayer? = null

    var currentSong = MutableLiveData<Title>()
    var isPlaying = MutableLiveData<Boolean>()

    init {
        isPlaying.value = false
    }

    fun setMusicPlayer(musicPlayer: MediaPlayer) {
        this.musicPlayer?.stop()
        this.musicPlayer?.release()
        this.musicPlayer = musicPlayer
        if (isPlaying.value!!) {
            this.musicPlayer?.start()
        }
    }

    fun setShuffler(shuffler: Shuffler) {
        this.shuffler = shuffler
    }

    fun progressTo(progress: Int) {
        val playProgress = currentSong.value!!.getLength() * progress / 100
        musicPlayer?.seekTo(playProgress)
    }

    fun buttonPlayPressed() {
        if (isPlaying.value!!) {
            musicPlayer?.pause()
        } else {
            musicPlayer?.start()
        }
        isPlaying.value = !isPlaying.value!!
    }

    fun buttonNextPressed(): Int {
        currentSong.value = shuffler?.nextTitle()
        return currentSong.value!!.getId()
    }


}