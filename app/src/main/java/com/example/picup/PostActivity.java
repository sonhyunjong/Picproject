package com.example.picup;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class PostActivity extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        ImageView imageView = (ImageView) findViewById(R.id.imageView2); // 이미지 받아오기
        Bundle extras = getIntent().getExtras();
        byte[] byteArray = getIntent().getByteArrayExtra("image");
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        Matrix matrix = new Matrix();
        matrix.postRotate(90);    //회전시킬 각도
        final Bitmap newBmp = Bitmap.createBitmap(bitmap, 0, 0, //bmp를 matrix로 회전하여 newBmp에
                bitmap.getWidth(), bitmap.getHeight(), matrix, true);

        imageView.setImageBitmap(newBmp);

        Button uploadButton = (Button) findViewById(R.id.btUpload);// 업로드 버튼
        uploadButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "upload", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(PostActivity.this, MainActivity.class);



            }
        });


    }

    public static Bitmap rotateImage(Bitmap source, float angle) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);

    }
}
