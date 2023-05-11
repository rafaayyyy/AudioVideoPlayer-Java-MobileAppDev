package com.example.audiovideoplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MusicAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<MusicClass> audioname;
    private LayoutInflater LI;

    public MusicAdapter(Context context, ArrayList<MusicClass> audioname) {
        this.context = context;
        this.audioname = audioname;
        this.LI = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return audioname.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = LI.inflate(R.layout.music_row_item,null);
        TextView TV = view.findViewById(R.id.audioname);
        TV.setText(audioname.get(i).getName());

        return view;
    }
}