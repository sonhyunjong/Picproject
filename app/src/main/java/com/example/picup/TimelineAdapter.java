package com.example.picup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class TimelineAdapter extends ArrayAdapter {

    private  Context context;
    private LayoutInflater inflater;

    private String[] imageUrls;


   /* @Override
    public int getCount() {
        return mThumbIds.length;
    }*/

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public TimelineAdapter (Context context,String[] imageUrls) {
        super(context, R.layout.listview_item_image, imageUrls);

        this.context = context;
        this.imageUrls = imageUrls;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (null == convertView) {
            convertView = inflater.inflate(R.layout.listview_item_image, parent, false);

        }

        Glide
                .with(context)
                .load(imageUrls[position])
                .centerCrop()
                .into((ImageView) convertView);

        return convertView;
    }



    }








