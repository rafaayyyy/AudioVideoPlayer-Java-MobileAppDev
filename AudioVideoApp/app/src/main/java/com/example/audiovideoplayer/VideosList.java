package com.example.audiovideoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class VideosList extends AppCompatActivity {

    private ListView LV;
    private ArrayList<VideoClass> videolist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos_list);
        this.setTitle("Videos List");

        LV = findViewById(R.id.videolistView);
        videolist = new ArrayList<>();
        getVideos();
        VideoAdapter videoAdapter = new VideoAdapter(VideosList.this, videolist);
        LV.setAdapter(videoAdapter);

        LV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(VideosList.this, VideoPlayerActivity.class);
                intent.putExtra("id",videolist.get(i).getId()).putExtra("name",videolist.get(i).getName()).putExtra("list",videolist).putExtra("position", i);
                startActivity(intent);
            }
        });
    }

    protected void getVideos(){
        VideoClass ran = new VideoClass();
        ran.setId(R.raw.video1);
        ran.setName("Video 1");
        videolist.add(ran);

        ran = new VideoClass();
        ran.setId(R.raw.video2);
        ran.setName("Video 2");
        videolist.add(ran);

        ran = new VideoClass();
        ran.setId(R.raw.video3);
        ran.setName("Video 3");
        videolist.add(ran);

        ran = new VideoClass();
        ran.setId(R.raw.video4);
        ran.setName("Video 4");
        videolist.add(ran);

        ran = new VideoClass();
        ran.setId(R.raw.video5);
        ran.setName("Video 5");
        videolist.add(ran);
    }
}