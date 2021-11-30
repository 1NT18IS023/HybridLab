package com.example.myapplication;



import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.song);
        Button bt1=findViewById(R.id.play);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Playing Song",Toast.LENGTH_LONG).show();
                mediaPlayer.start();
            }
        });
        Button bt2=findViewById(R.id.pause);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Pausing Song",Toast.LENGTH_LONG).show();
                mediaPlayer.pause();
            }
        });

        Button bt3 = findViewById(R.id.forward);
        bt3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                double cur_time = mediaPlayer.getCurrentPosition();
                double total = mediaPlayer.getDuration();
                if(cur_time == total)
                    Toast.makeText(getApplicationContext(), "Can't fast forward",Toast.LENGTH_LONG).show();
                 else
                     mediaPlayer.seekTo((int)cur_time+5000);
            }
        });

        Button bt4 = findViewById(R.id.rewind);
        bt4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                double cur_time = mediaPlayer.getCurrentPosition();

                if(cur_time == 0)
                    Toast.makeText(getApplicationContext(), "Can't rewind",Toast.LENGTH_LONG).show();
                else
                    mediaPlayer.seekTo((int)cur_time-5000);
            }
        });

        Button bt5 = findViewById(R.id.stop);
        bt5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                double cur_time = mediaPlayer.getCurrentPosition();
                Toast.makeText(getApplicationContext(), "Stopping",Toast.LENGTH_LONG).show();
                mediaPlayer.seekTo(0);
                mediaPlayer.pause();
            }
        });
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

            }
        });
    }
}