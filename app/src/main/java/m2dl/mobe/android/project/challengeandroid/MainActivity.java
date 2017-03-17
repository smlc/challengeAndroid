package m2dl.mobe.android.project.challengeandroid;

import android.media.MediaPlayer;
import android.os.Handler;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;



import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final long DEFAULT_ANIMATION_DURATION = 2500L;
    private float mScreenHeight;

    private Random randomFreq;
    int max = 300;
    int min = 100;
    int rand;
    private Handler mHandler;
    private CreateImage buttonCreater;

    public MediaPlayer playSound1,playSound2,playSound3,playSound4,playSound5,airHorn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    private Runnable mUpdateTimeTask = new Runnable() {
        @Override
        public void run() {

            Random randomNumber = new Random();
            int rand = randomNumber.nextInt(5);

            switch (rand) {
                case 1:
                    playSound1.start();
                    break;
                case 2:
                    playSound2.start();
                    break;
                case 3:
                    playSound3.start();
                    break;
                case 4:
                    playSound4.start();
                    break;
                case 5:
                    playSound5.start();
                    break;
            }

            rand = randomFreq.nextInt(max -min)+min;
            mHandler.postDelayed(this,rand);
        }
    };


}
