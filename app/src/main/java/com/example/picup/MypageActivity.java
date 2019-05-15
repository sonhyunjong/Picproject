package com.example.picup;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MypageActivity extends AppCompatActivity {

   protected void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_mypage);



       ImageView iv= (ImageView)findViewById(R.id.imageView);
       Glide.with(this).load("https://img.insight.co.kr/static/2018/09/15/700/747cl3tq51cz06846r5u.jpg").into(iv);


        GridView gridview=(GridView)findViewById(R.id.GridView);
        gridview.setAdapter(new ImageAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });


    }
}
