<<<<<<< HEAD

package com.example.picup;

        import android.content.Intent;
        import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;
        import android.graphics.Matrix;
        import android.media.ExifInterface;
        import android.net.Uri;
        import android.os.Bundle;
        import android.provider.MediaStore;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.Toast;

        import java.io.ByteArrayOutputStream;
        import java.io.File;
        import java.io.IOException;
=======
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
>>>>>>> 0ca01f0bcb8051481652daf3e19224866d19480f

public class PostActivity extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

<<<<<<< HEAD
        ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        final Intent getintent = getIntent();
        File file = new File(getintent.getStringExtra("Path"));
        Bitmap bitmap = null;

        try {
            bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.fromFile(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(90);    //회전시킬 각도


=======
        ImageView imageView = (ImageView) findViewById(R.id.imageView2); // 이미지 받아오기
        Bundle extras = getIntent().getExtras();
        byte[] byteArray = getIntent().getByteArrayExtra("image");
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        Matrix matrix = new Matrix();
        matrix.postRotate(90);    //회전시킬 각도
>>>>>>> 0ca01f0bcb8051481652daf3e19224866d19480f
        final Bitmap newBmp = Bitmap.createBitmap(bitmap, 0, 0, //bmp를 matrix로 회전하여 newBmp에
                bitmap.getWidth(), bitmap.getHeight(), matrix, true);

        imageView.setImageBitmap(newBmp);
<<<<<<< HEAD
=======

>>>>>>> 0ca01f0bcb8051481652daf3e19224866d19480f
        Button uploadButton = (Button) findViewById(R.id.btUpload);// 업로드 버튼
        uploadButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
<<<<<<< HEAD
                Intent updateIntent = new Intent();
                updateIntent.putExtra("upload",true);
                setResult(0,updateIntent);
                Toast.makeText(getApplicationContext(), "upload", Toast.LENGTH_SHORT).show();
                finish();
=======
                Toast.makeText(getApplicationContext(), "upload", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(PostActivity.this, MainActivity.class);



>>>>>>> 0ca01f0bcb8051481652daf3e19224866d19480f
            }
        });


    }

    public static Bitmap rotateImage(Bitmap source, float angle) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);

    }
<<<<<<< HEAD

=======
>>>>>>> 0ca01f0bcb8051481652daf3e19224866d19480f
}
