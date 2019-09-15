package com.example.flash;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    Thread time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.ak);
        mediaPlayer.start();
        time = new Thread() {
            public void run() {
                try {
                    sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                   Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                   startActivity(intent);
                }
            }
        };
        time.start();
    }
}

