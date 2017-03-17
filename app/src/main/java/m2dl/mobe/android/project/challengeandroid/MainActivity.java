package m2dl.mobe.android.project.challengeandroid;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

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
