package m2dl.mobe.android.project.challengeandroid.Activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import m2dl.mobe.android.project.challengeandroid.R;

/**
 * Created by rottanaly on 3/17/17.
 */

public class PlayMusicActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private int songNb = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            songNb = extras.getInt("song");
        }
        mediaPlayer = new MediaPlayer();
        if (songNb == 2) {
            mediaPlayer = MediaPlayer.create(this, R.raw.song2);
        } else {
            mediaPlayer = MediaPlayer.create(this, R.raw.song1);
        }
        mediaPlayer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
    }
}