package m2dl.mobe.android.project.challengeandroid.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import m2dl.mobe.android.project.challengeandroid.Domain.Score;
import m2dl.mobe.android.project.challengeandroid.R;

/**
 * Created by rottanaly on 3/17/17.
 */

public class ScoreActivity extends AppCompatActivity {

    private Button buttonBack;
    private TextView tvScore1, tvScore2, tvScore3, tvScore4, tvScore5;
    private Score score = PlayMusicActivity.score;
    private int[] topScores = new int[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        tvScore1 = (TextView) findViewById(R.id.tvScore1);
        tvScore2 = (TextView) findViewById(R.id.tvScore2);
        tvScore3 = (TextView) findViewById(R.id.tvScore3);
        tvScore4 = (TextView) findViewById(R.id.tvScore4);
        tvScore5 = (TextView) findViewById(R.id.tvScore5);

        score.sortList(score.getList());


        for (int i=0; i<5; i++) {
            int p = 0;
            if (i < score.getList().size()) {
                p = score.getList().get(i);
            }
            topScores[i] = p;
        }
        // Initialize top scores
        tvScore1.setText("1. " + topScores[0] + " pts");
        tvScore2.setText("2. " + topScores[1] + " pts");
        tvScore3.setText("3. " + topScores[2] + " pts");
        tvScore4.setText("4. " + topScores[3] + " pts");
        tvScore5.setText("5. " + topScores[4] + " pts");

        buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScoreActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
