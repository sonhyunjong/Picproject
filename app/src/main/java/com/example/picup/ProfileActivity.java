
package com.example.picup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ProfileActivity extends AppCompatActivity {

    ImageView Bigprofile;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Bigprofile = (ImageView) findViewById(R.id.bigprofile);
        startLoadingProfile();
    }


    private void startLoadingProfile() {
        String url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQvcRuYRG7aD2EnvZmMFobbFvqjaYsQKZxwILZ4Vu5mn6sERF30-Q";

        Glide
                .with(this)
                .load(url)
                .into(Bigprofile);
    }
}

