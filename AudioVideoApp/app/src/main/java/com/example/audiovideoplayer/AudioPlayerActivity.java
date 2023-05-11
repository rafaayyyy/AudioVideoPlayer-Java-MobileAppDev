package com.example.audiovideoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class AudioPlayerActivity extends AppCompatActivity {

    private MediaPlayer mPlayer;
    private boolean playerReleased = false;
    private boolean dummy = false;
    private Handler handler;
    SeekBar seekBar;
    int id;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_player_play);
        id = getIntent().getIntExtra("id",0);
        name = getIntent().getStringExtra("name");

        this.setTitle("Music Player");

        mPlayer = MediaPlayer.create(AudioPlayerActivity.this, id);
        Button playBtn = (Button) findViewById(R.id.play);
        Button pauseBtn = (Button) findViewById(R.id.pause);
        Button stopBtn = (Button) findViewById(R.id.stop);
        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(mPlayer.getDuration());
        int time = mPlayer.getDuration();
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mPlayer == null || playerReleased){
                    mPlayer = MediaPlayer.create(AudioPlayerActivity.this, id);
                    playerReleased = false;
                }
                mPlayer.start();
            }

        });
        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mPlayer != null){
                    mPlayer.pause();
                }
            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mPlayer!=null){
                    playerReleased = true;
//                    mPlayer.seekTo(0);
                    mPlayer.seekTo(mPlayer.getDuration());
                    seekBar.setProgress(mPlayer.getDuration());

//                    mPlayer.release();
//                    Intent returnBtn = new Intent(getApplicationContext(), AudioPlayer.class);
//                    startActivity(returnBtn);
                }
            }
        });



        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seekBar.setProgress(mPlayer.getCurrentPosition());
            }
        }, 0, 900);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(time == progress){

                    Intent returnBtn = new Intent(getApplicationContext(), AudioPlayer.class);
                    startActivity(returnBtn);
                }
                mPlayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    @Override
    public void onBackPressed () {
//        mPlayer.release();
//        mPlayer = MediaPlayer.create(AudioPlayerActivity.this, id);
//        mPlayer.seekTo(mPlayer.getDuration());
//        seekBar.setProgress(mPlayer.getDuration());
////        if(playerReleased == false)
////        {
////            playerReleased = true;
////        }
////        Intent returnBtn = new Intent(getApplicationContext(), AudioPlayer.class);
////        startActivity(returnBtn);
////        if(mPlayer!=null){
////            playerReleased = true;
//////                    mPlayer.seekTo(0);
////            seekBar.setProgress(mPlayer.getDuration());
////                    mPlayer.release();
////                    Intent returnBtn = new Intent(getApplicationContext(), AudioPlayer.class);
////                    startActivity(returnBtn);
////        }
////        if(playerReleased!=false){
////            playerReleased = true;
////            mPlayer.release();
////        }
////        seekBar.setProgress(mPlayer.getDuration());
////        Intent returnBtn = new Intent(getApplicationContext(), AudioPlayer.class);
////        startActivity(returnBtn);

    }

    protected void onDestroy() {
        super.onDestroy();
        mPlayer.release();
    }
}