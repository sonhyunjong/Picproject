package com.example.picup;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class TimelineAdapter extends BaseAdapter {
    private Context mContext;
    public TimelineAdapter(Context c){
        mContext=c;
    }
    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.MarginLayoutParams(300, 300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else
            imageView = (ImageView) convertView;
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }
    private Integer[] mThumbIds={
            R.drawable.lena,
            R.drawable.lena,
            R.drawable.lena,
            R.drawable.lena,
            R.drawable.lena,
            R.drawable.lena,
            R.drawable.lena,
            R.drawable.lena,



    };

    }
