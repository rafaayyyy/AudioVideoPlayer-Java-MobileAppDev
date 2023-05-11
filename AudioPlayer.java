package com.example.audiovideoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AudioPlayer extends AppCompatActivity {

    private FloatingActionButton fab;
    private ListView LV;
    private ArrayList<MusicClass> musiclist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_player);

        this.setTitle("Music Player");

        fab = findViewById(R.id.audiofab);

        LV = findViewById(R.id.audiolistView);
        musiclist = new ArrayList<>();
        getAudios();
        MusicAdapter audioAdapter = new MusicAdapter(AudioPlayer.this, musiclist);
        LV.setAdapter(audioAdapter);

        LV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(AudioPlayer.this, AudioPlayerActivity.class);
                intent.putExtra("id",musiclist.get(i).getId()).putExtra("name",musiclist.get(i).getName());
                startActivity(intent);
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AudioPlayer.this,VideoPlayer.class);
                startActivity(intent);
            }
        });


    }

    protected void getAudios(){
        MusicClass ran = new MusicClass();
        ran.setId(R.raw.audio1);
        ran.setName("Music 1");
        musiclist.add(ran);

        ran = new MusicClass();
        ran.setId(R.raw.audio2);
        ran.setName("Music 2");
        musiclist.add(ran);

        ran = new MusicClass();
        ran.setId(R.raw.audio3);
        ran.setName("Music 3");
        musiclist.add(ran);

        ran = new MusicClass();
        ran.setId(R.raw.audio4);
        ran.setName("Music 4");
        musiclist.add(ran);

        ran = new MusicClass();
        ran.setId(R.raw.audio5);
        ran.setName("Music 5");
        musiclist.add(ran);

        ran = new MusicClass();
        ran.setId(R.raw.audio6);
        ran.setName("Music 6");
        musiclist.add(ran);

        ran = new MusicClass();
        ran.setId(R.raw.audio7);
        ran.setName("Music 7");
        musiclist.add(ran);

        ran = new MusicClass();
        ran.setId(R.raw.audio8);
        ran.setName("Music 8");
        musiclist.add(ran);

        ran = new MusicClass();
        ran.setId(R.raw.audio9);
        ran.setName("Music 9");
        musiclist.add(ran);

        ran = new MusicClass();
        ran.setId(R.raw.audio10);
        ran.setName("Music 10");
        musiclist.add(ran);

    }

    @Override
    public void onBackPressed () {

    }
}