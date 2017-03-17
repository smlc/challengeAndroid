package m2dl.mobe.android.project.challengeandroid.Activity;

import android.animation.ObjectAnimator;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;

import m2dl.mobe.android.project.challengeandroid.CreateImage;
import m2dl.mobe.android.project.challengeandroid.R;

/**
 * Created by rottanaly on 3/17/17.
 */

public class PlayMusicActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private int songNb = 1;
    private static final long DEFAULT_ANIMATION_DURATION = 2500L;
    private float mScreenHeight;

    private Random randomFreq;
    int max = 300;
    int min = 100;
    int rand;
    private Handler mHandler;
    private CreateImage buttonCreater;
    private RelativeLayout relativeLayout;
    public MediaPlayer playSound1,playSound2,playSound3,playSound4,playSound5;
    private  int frenqueShake = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        Bundle extras = getIntent().getExtras();
        relativeLayout = (RelativeLayout) findViewById(R.id.gameRelativeLayout);
        buttonCreater = new CreateImage(this, relativeLayout);

        initPlayer();


        randomFreq = new Random();
        rand = randomFreq.nextInt(max -min + 1)+min;

        mHandler = new Handler();
        mHandler.postDelayed(mUpdateTimeTask,rand);

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

    private void initPlayer() {
        playSound1 = MediaPlayer.create(this, R.raw.sound1);
        playSound2 = MediaPlayer.create(this, R.raw.sound2);
        playSound3 = MediaPlayer.create(this, R.raw.sound3);
        playSound4 = MediaPlayer.create(this, R.raw.sound4);
        playSound5 = MediaPlayer.create(this, R.raw.sound5);
    }

    private void onStartAnimation(ImageView img){

        ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(img, "rotation", 0, 180f);
        rotationAnimator.setDuration(DEFAULT_ANIMATION_DURATION);
        rotationAnimator.start();


    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
    }

    private Runnable mUpdateTimeTask = new Runnable() {

        @Override
        public void run() {

            if(frenqueShake == 20){
                generateShake();
                frenqueShake = 0;
            }else {
                frenqueShake++;
                generateSoundAndButton();
            }



            int rand;

            rand = randomFreq.nextInt(max -min)+min;
            mHandler.postDelayed(this,rand);
        }
    };

    private void generateShake() {
    }

    private void generateSoundAndButton() {
        Random randomNumber = new Random();
        int rand = randomNumber.nextInt(5);

        switch (rand) {
            case 1:
                playSound1.start();
                ImageView img = buttonCreater.createRandomButton();
                relativeLayout.addView(img);
                break;
            case 2:
                playSound2.start();
                ImageView img2 = buttonCreater.createRandomButton();
                relativeLayout.addView(img2);
                break;
            case 3:
                playSound3.start();
                ImageView img3 = buttonCreater.createRandomButton();
                relativeLayout.addView(img3);
                break;
            case 4:
                playSound4.start();
                ImageView img4 = buttonCreater.createRandomButton();
                relativeLayout.addView(img4);
                break;
            case 5:
                playSound5.start();
                ImageView img5 = buttonCreater.createRandomButton();
                relativeLayout.addView(img5);
                break;
        }
    }
}