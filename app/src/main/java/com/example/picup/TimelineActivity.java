package com.example.picup;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
<<<<<<< HEAD
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
=======
import android.view.View;
>>>>>>> 0ca01f0bcb8051481652daf3e19224866d19480f
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
<<<<<<< HEAD
import android.widget.ImageView;

import com.bumptech.glide.Glide;

//import me.relex.circleindicator.CircleIndicator;
=======

import me.relex.circleindicator.CircleIndicator;
>>>>>>> 0ca01f0bcb8051481652daf3e19224866d19480f

public class TimelineActivity extends AppCompatActivity {
    FragmentPagerAdapter adapterViewPager;

<<<<<<< HEAD


    public static String[] eatFoodyImages = {
            "http://i.imgur.com/rFLNqWI.jpg",
            "http://i.imgur.com/C9pBVt7.jpg",
            "http://i.imgur.com/rT5vXE1.jpg",
            "http://i.imgur.com/aIy5R2k.jpg",
            "http://i.imgur.com/MoJs9pT.jpg",
            "http://i.imgur.com/S963yEM.jpg",
            "http://i.imgur.com/rLR2cyc.jpg",
            "http://i.imgur.com/SEPdUIx.jpg",
            "http://i.imgur.com/aC9OjaM.jpg",
            "http://i.imgur.com/76Jfv9b.jpg",
            "http://i.imgur.com/fUX7EIB.jpg",
            "http://i.imgur.com/syELajx.jpg",
            "http://i.imgur.com/COzBnru.jpg",
            "http://i.imgur.com/Z3QjilA.jpg",
    };



    private Context context =TimelineActivity.this;

    private String stockPhotoUrl = "https://cdn.pixabay.com/photo/2017/07/31/11/14/poppyseed-2557339_1280.jpg";



=======
>>>>>>> 0ca01f0bcb8051481652daf3e19224866d19480f
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

<<<<<<< HEAD
        /*CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(vpPager);*/
=======
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(vpPager);
>>>>>>> 0ca01f0bcb8051481652daf3e19224866d19480f


        GridView gridview = (GridView) findViewById(R.id.TimelineGridView);

<<<<<<< HEAD
        gridview.setAdapter(new TimelineAdapter(TimelineActivity.this,
                eatFoodyImages)
        );
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(),MypageActivity.class);
                startActivity(intent);
            }
        });

=======
        gridview.setAdapter(new TimelineAdapter(this));
>>>>>>> 0ca01f0bcb8051481652daf3e19224866d19480f


    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 3;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    return FirstFragment.newInstance(0, "Page # 1");
                case 1:
                    return SecondFragment.newInstance(1, "Page # 2");
                case 2:
                    return ThirdFragment.newInstance(2, "Page # 3");
                default:
                    return null;
            }


        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

    }



}
<<<<<<< HEAD


=======
>>>>>>> 0ca01f0bcb8051481652daf3e19224866d19480f
