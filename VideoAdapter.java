package com.example.audiovideoplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class VideoAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<VideoClass> videoname;
    private LayoutInflater LI;

    public VideoAdapter(Context context, ArrayList<VideoClass> videoname) {
        this.context = context;
        this.videoname = videoname;
        this.LI = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return videoname.size();
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

        view = LI.inflate(R.layout.video_row_item,null);
        TextView TV = view.findViewById(R.id.videoname);
        TV.setText(videoname.get(i).getName());

        return view;
    }
}