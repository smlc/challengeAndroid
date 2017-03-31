package m2dl.mobe.android.project.challengeandroid.Activity;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

import m2dl.mobe.android.project.challengeandroid.CreateImage;
import m2dl.mobe.android.project.challengeandroid.Domain.Score;
import m2dl.mobe.android.project.challengeandroid.R;
import m2dl.mobe.android.project.challengeandroid.ShakeDetector;

/**
 * Created by rottanaly on 3/17/17.
 */

public class PlayMusicActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener {
    private static final int MAX_SCORE = 30 ;
    private MediaPlayer mediaPlayer;
    private int songNb = 1;
    private static final long DEFAULT_ANIMATION_DURATION = 2500L;
    private float mScreenHeight;
    public static Score score = new Score();
    private Random randomFreq;
    int max = 1000;
    int min = 300;
    int rand;
    private Handler mHandler;
    private CreateImage buttonCreater;
    private RelativeLayout relativeLayout;
    public MediaPlayer playSound1,playSound2,playSound3,playSound4,playSound5,airHorn;
    private  int frenqueShake = 0;
    private ImageView img;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4, img5;
    private int currentScore = 20;
    private TextView scoreView;
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;
    private TextView tvShake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        Bundle extras = getIntent().getExtras();
        relativeLayout = (RelativeLayout) findViewById(R.id.gameRelativeLayout);
        buttonCreater = new CreateImage(this, relativeLayout);
        scoreView = (TextView) findViewById(R.id.tvGameScore);
        tvShake = (TextView) findViewById(R.id.tvShake);
        initPlayer();


        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager
                .getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector();
        mShakeDetector.setOnShakeListener(new ShakeDetector.OnShakeListener() {

            @Override
            public void onShake(int count) {
                tvShake.setText("");
                currentScore =+ 5;
                System.out.println(count);
            }
        });

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
        airHorn = MediaPlayer.create(this, R.raw.hornsound);
    }

    private void onStartAnimation(ImageView img){

        ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(img, "rotation", 0, 180f);
        rotationAnimator.setDuration(DEFAULT_ANIMATION_DURATION);
        rotationAnimator.start();


    }

    @Override
    public void onResume() {
        super.onResume();
        // Add the following line to register the Session Manager Listener onResume
        mSensorManager.registerListener(mShakeDetector, mAccelerometer,	SensorManager.SENSOR_DELAY_UI);
    }


    @Override
    protected void onPause() {
        mSensorManager.unregisterListener(mShakeDetector);
        super.onPause();
        mediaPlayer.stop();
        playSound1.stop();
        playSound2.stop();
        playSound3.stop();
        playSound4.stop();
        playSound5.stop();
        airHorn.stop();
    }

    private Runnable mUpdateTimeTask = new Runnable() {

        @Override
        public void run() {

            if(frenqueShake == 10){
               tvShake.setText("SHAKE IT !!!!!");
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

                img = buttonCreater.createRandomButton();

                playSound1.setOnCompletionListener(this);
                img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setVisibility(View.INVISIBLE);
                        currentScore++;
                        updateScore();
                    }
                });
                relativeLayout.addView(img);
                break;
            case 2:
                playSound2.start();
                playSound2.setOnCompletionListener(this);

                img2 = buttonCreater.createRandomButton();
                img2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setVisibility(View.INVISIBLE);
                        currentScore++;
                        updateScore();
                    }
                });
                relativeLayout.addView(img2);
                break;
            case 3:
                playSound3.start();
                playSound3.setOnCompletionListener(this);
                img3 = buttonCreater.createRandomButton();
                img3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setVisibility(View.INVISIBLE);
                        currentScore++;
                        updateScore();

                    }
                });
                relativeLayout.addView(img3);
                break;
            case 4:
                playSound4.start();
                playSound4.setOnCompletionListener(this);
                img4 = buttonCreater.createRandomButton();
                img4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setVisibility(View.INVISIBLE);
                        currentScore++;
                        updateScore();
                    }
                });
                relativeLayout.addView(img4);
                break;
            case 5:
                playSound5.start();
                playSound5.setOnCompletionListener(this);
                img5 = buttonCreater.createRandomButton();
                img5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setVisibility(View.INVISIBLE);
                        currentScore++;
                        updateScore();
                    }
                });
                relativeLayout.addView(img5);
                break;
        }


    }

    private void updateScore() {
        scoreView.setText(""+currentScore);
        if(currentScore == MAX_SCORE){
            score.addPoint(currentScore);
            Intent intent = new Intent(this, ScoreActivity.class);
            intent.putExtra("START_SCORE", currentScore);
            startActivity(intent);
        }
    }


    @Override
    public void onCompletion(MediaPlayer mp) {
        if(mp.equals(playSound1)){
            setToInvisible(img);
        }else if(mp.equals(playSound2)){
            setToInvisible(img2);
        }else if(mp.equals(playSound3)){
            setToInvisible(img3);
        }else if(mp.equals(playSound4)){
            setToInvisible(img4);
        }else if(mp.equals(playSound5)){
            setToInvisible(img5);
        }
    }

    private void setToInvisible(ImageView img) {
        if(img.getVisibility() == View.VISIBLE){
            img.setVisibility(View.INVISIBLE);
            airHorn.start();
            if(currentScore == 0){
                score.addPoint(currentScore);
                Intent intent = new Intent(this, ScoreActivity.class);
                intent.putExtra("START_SCORE", currentScore);
                startActivity(intent);
            }
            currentScore--;
            scoreView.setText(""+currentScore);
        }
    }
}