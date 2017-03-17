package m2dl.mobe.android.project.challengeandroid;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;

/**
 * Created by MarS on 17/03/2017.
 */

public class CreateImage {

    float xRandom;
    float yRandom;
    private Context context;
    private RelativeLayout relativeLayout;
    public CreateImage(Context context, RelativeLayout relativeLayout){
        this.context = context;
        this.relativeLayout = relativeLayout;
    }


    public ImageView createRandomButton(){
        ImageView buttonView = new ImageButton(context);
        buttonView.setImageResource(R.drawable.ic_android_black_24dp);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        Point screenSize= new Point();
        ((Activity)context).getWindowManager().getDefaultDisplay().getSize(screenSize);

        int screenWidth = screenSize.x;
        int screenHeight = screenSize.y;

        RelativeLayout.LayoutParams layoutParam = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);



        Random r = new Random();
        xRandom = r.nextInt(screenWidth - buttonView.getWidth());
        yRandom = r.nextInt(screenHeight - buttonView.getHeight());
        buttonView.setLayoutParams(layoutParam);
        buttonView.setX(xRandom);
        buttonView.setY(yRandom);



        return buttonView;


    }


}
