package m2dl.mobe.android.project.challengeandroid.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import m2dl.mobe.android.project.challengeandroid.R;

/**
 * Created by rottanaly on 3/17/17.
 */

public class StartActivity extends AppCompatActivity {

    private RadioGroup radioSong, radioLevel;
    private RadioButton radioSongSelected, radioLevelSelected;
    private Button buttonPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        radioSong = (RadioGroup) findViewById(R.id.radioSong);
        radioLevel = (RadioGroup) findViewById(R.id.radioLevel);

        buttonPlay = (Button) findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedIDSong = radioSong.getCheckedRadioButtonId();
                int selectedIDLevel = radioLevel.getCheckedRadioButtonId();

                radioSongSelected = (RadioButton) findViewById(selectedIDSong);
                radioLevelSelected = (RadioButton) findViewById(selectedIDLevel);

                String song = (String) radioSongSelected.getText();
                String level = (String) radioLevelSelected.getText();

                Toast.makeText(StartActivity.this,  song + ", " + level, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(StartActivity.this, PlayMusicActivity.class);
                int songNb = 2;
                if (song.contains("1")) {
                    songNb = 1;
                }
                System.out.println("Song number: " + songNb);
                intent.putExtra("song", songNb);
                startActivity(intent);
            }
        });
    }
}
