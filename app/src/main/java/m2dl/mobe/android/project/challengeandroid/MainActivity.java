package m2dl.mobe.android.project.challengeandroid;


import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    private static final long DEFAULT_ANIMATION_DURATION = 2500L;
    private float mScreenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void onStartAnimation(ImageView img){

        ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(img, "rotation", 0, 180f);
        rotationAnimator.setDuration(DEFAULT_ANIMATION_DURATION);
        rotationAnimator.start();
    }
}
