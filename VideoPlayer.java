package com.example.audiovideoplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class VideoPlayer extends AppCompatActivity {

    private FloatingActionButton fab;
    private LinearLayout LL;
    private RelativeLayout r1,r2,r3;
    final int requestCode = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        this.setTitle("Video Player Options");

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, requestCode);
        }

        fab = findViewById(R.id.videofab);

        r1 = findViewById(R.id.videoOption);
        r2 = findViewById(R.id.webviewOption);
        r3 = findViewById(R.id.implicitOption);

        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VideoPlayer.this,VideosList.class);
                startActivity(intent);
            }
        });

        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoClass video = new VideoClass("WebView Video", "https://youtu.be/rfTgO9rpqck");
                Intent intent = new Intent(VideoPlayer.this,WebViewActivity.class);
                intent.putExtra("url", video.getUrl());
                startActivity(intent);
            }
        });

        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoClass video = new VideoClass("Implicit Video", "https://youtu.be/2nvsGz70ZT0");
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(video.getUrl()));
                startActivity(intent);
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VideoPlayer.this,AudioPlayer.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed () {

    }
}