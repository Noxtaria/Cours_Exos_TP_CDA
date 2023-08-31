package com.example.app_sound;

import android.media.MediaPlayer;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playSound(View view) {
        int soundId = 0;

        if (view.getId() == R.id.buttonBlack) {
            soundId = R.raw.black;
        } else if (view.getId() == R.id.buttonGreen) {
            soundId = R.raw.green;
        } else if (view.getId() == R.id.buttonPurple) {
            soundId = R.raw.purple;
        } else if (view.getId() == R.id.buttonRed) {
            soundId = R.raw.red;
        } else if (view.getId() == R.id.buttonYellow) {
            soundId = R.raw.yellow;
        }

        if (soundId != 0) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, soundId);
            mediaPlayer.start();
        }
    }
}