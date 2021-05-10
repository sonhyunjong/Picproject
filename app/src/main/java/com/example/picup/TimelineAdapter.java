package com.example.picup;

import android.content.Context;
<<<<<<< HEAD
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
=======
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
>>>>>>> 0ca01f0bcb8051481652daf3e19224866d19480f

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

<<<<<<< HEAD
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







=======
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.MarginLayoutParams(360, 490));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(1, 1, 1, 1);
        } else
            imageView = (ImageView) convertView;
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }
    private Integer[] mThumbIds={
            R.drawable.sns,
            R.drawable.sns1,
            R.drawable.sns2,
            R.drawable.sns3,
            R.drawable.sns4,
            R.drawable.sns5,
            R.drawable.sns6,
            R.drawable.sns7,
            R.drawable.sns8,
            R.drawable.sns9

    };

}
>>>>>>> 0ca01f0bcb8051481652daf3e19224866d19480f

