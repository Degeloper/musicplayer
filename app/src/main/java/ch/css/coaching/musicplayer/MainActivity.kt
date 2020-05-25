package ch.css.coaching.musicplayer

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageView
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ch.css.coaching.musicplayer.music.Mapper
import ch.css.coaching.musicplayer.persistence.Repository
import ch.css.coaching.musicplayer.player.PlayerViewModel
import ch.css.coaching.musicplayer.shuffle.Shuffler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = ViewModelProviders.of(this).get(PlayerViewModel::class.java)

        viewModel.setShuffler(Shuffler(Repository(), Mapper()))

        viewModel.currentSong.observe(this, Observer {
            imgAlbum.setImageResource(it.getAlbumArt())
            txtSong.text = it.getTitle()
            txtBand.text = it.getArtist()
        })

        viewModel.isPlaying.observe(this, Observer { isPlaying ->
            btnPlay.setImageResource(
                when {
                    isPlaying -> android.R.drawable.ic_media_pause
                    else -> android.R.drawable.ic_media_play
                }
            )
        })

        sldProgress.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    viewModel.progressTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        btnPlay.setOnClickListener {
            viewModel.buttonPlayPressed()
        }

        btnNext.setOnClickListener {
            val id = viewModel.buttonNextPressed()
            viewModel.setMusicPlayer(createSong(id))
        }
    }

    private fun createSong(id: Int): MediaPlayer {
        return MediaPlayer.create(this, id)
    }

}
