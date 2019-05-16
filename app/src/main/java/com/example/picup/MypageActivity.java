package com.example.picup;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MypageActivity extends AppCompatActivity {

    ImageView profile;
    GridView mypheed;

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

    private Context context =MypageActivity.this;

    private String stockPhotoUrl = "https://cdn.pixabay.com/photo/2017/07/31/11/14/poppyseed-2557339_1280.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);



        GridView gridView = (GridView) findViewById(R.id.activity_image_gridview);

        gridView.setAdapter(
                new ImageAdapter(
                        MypageActivity.this,
                        eatFoodyImages
                )
        );
        profile=  (ImageView) findViewById(R.id.imageprofile);

        startLoadingProfile();

        profile.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent Profileintent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(Profileintent);
            }

        });




    }

  /*  public String makeImageFilePath(){

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMdd_hhmmss");
        Date date=new Date();
        String strDate=simpleDateFormat.format(date);
        return strDate+".png";
    }*/

   /* public File crateFileFromBitmap(Bitmap bitmap) throws IOException {

        File newFile=new File(getFilesDir(),makeImageFilePath());
        FileOutputStream fileOutputStream=new FileOutputStream(newFile);
        bitmap.compress(Bitmap.CompressFormat.PNG,100,fileOutputStream);
        fileOutputStream.close();
        return newFile;
    }*/
    private void startLoadingProfile() {
        String url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQvcRuYRG7aD2EnvZmMFobbFvqjaYsQKZxwILZ4Vu5mn6sERF30-Q";

        Glide
                .with(this)
                .load(url)
                .into(profile);
    }
    /*private Bitmap getBitmapFormUri(Uri uri)throws IOException{
        ParcelFileDescriptor parcelFileDescriptor =
                getContentResolver().openFileDescriptor(uri, "r");
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();

        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inJustDecodeBounds = true;//크기정보만 가져옴
        BitmapFactory.decodeFileDescriptor(fileDescriptor, null, opts);

        int width = opts.outWidth;
        int height = opts.outHeight;

        float sampleRatio = getSampleRatio(width, height);

        opts.inJustDecodeBounds = false;
        opts.inSampleSize = (int) sampleRatio;

        Bitmap resizedBitmap = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, opts);

        Log.d("Resizing", "Resized Width / Height : " + resizedBitmap.getWidth() + "/" + resizedBitmap.getHeight());

        parcelFileDescriptor.close();

        return resizedBitmap;
    }

    private float getSampleRatio(int width, int height) {
        final int targetWidth = 1280;
        final int targetheight = 1280;

        float ratio;

        if (width > height) {
            // Landscape
            if (width > targetWidth) {
                ratio = (float) width / (float) targetWidth;
            } else ratio = 1f;
        } else {
            // Portrait
            if (height > targetheight) {
                ratio = (float) height / (float) targetheight;
            } else ratio = 1f;
        }

        return Math.round(ratio);
    }*/
}
