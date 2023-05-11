package com.example.audiovideoplayer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;

public class VideoPlayerActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener {

    private VideoView videoView;
    ArrayList<VideoClass> videoList;
    private int currentVideo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player_play);

        this.setTitle("Video Player");

        int id = getIntent().getIntExtra("id",0);
        int pos = getIntent().getIntExtra("position",0);
        String name = getIntent().getStringExtra("name");
        videoList = new ArrayList<VideoClass>();
        videoList = (ArrayList<VideoClass>) getIntent().getSerializableExtra("list");
        videoView = (VideoView)findViewById(R.id.video_view);
        videoView.setMediaController(new MediaController(this));
        videoView.setOnCompletionListener(this);
        setVideo(videoList.get(pos).getId());
    }
    public void setVideo(int id) {
        String uriPath = "android.resource://" + getPackageName() + "/" + id;
        Uri uri = Uri.parse(uriPath);
        videoView.setVideoURI(uri);
        videoView.start();
    }
    @Override
    public void onCompletion(MediaPlayer player) {
        AlertDialog.Builder obj = new AlertDialog.Builder(this);
        obj.setTitle("Playback Finished");
        obj.setIcon(R.mipmap.ic_launcher);
        MyListener myListener = new MyListener();
        obj.setPositiveButton("Next", myListener);
        obj.setNegativeButton("Replay", myListener);
        obj.setMessage("Want to replay or play next video?");
        obj.show();
    }


    class MyListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which)
        {
            if (which == -1) {
                ++currentVideo;
                if (currentVideo == videoList.size()) {
                    currentVideo = 0;
                }
                setVideo(videoList.get(currentVideo).getId());
            }
            else {
                videoView.seekTo(0);
                videoView.start();
            }
        }
    }
}