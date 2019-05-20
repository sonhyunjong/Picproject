package com.example.picup;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.media.ExifInterface;
import android.media.Image;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import net.daum.mf.map.api.CalloutBalloonAdapter;
import net.daum.mf.map.api.CameraUpdateFactory;
import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapPointBounds;
import net.daum.mf.map.api.MapReverseGeoCoder;
import net.daum.mf.map.api.MapView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static android.app.PendingIntent.getActivity;


public class MainActivity extends AppCompatActivity implements MapView.POIItemEventListener, MapView.CurrentLocationEventListener, MapReverseGeoCoder.ReverseGeoCodingResultListener{

    MapMarkerVO marker= new MapMarkerVO();
    private String mCurrentPhotoPath;

    private  View mCalloutBalloon;
    static final int REQUEST_TAKE_PHOTO=1;
    final static int TAKE_PICTURE=1;
    MapView mapView ;
    private MapPOIItem mCustomMarker;
    private MapPOIItem mCustomBmMarker;





    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapView = new MapView(this);
        mapView.setDaumMapApiKey("ead955228613545283791950dc488bac");
        mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithHeading);
        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
//        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(37.53737528, 127.00557633), true);
        mapView.setZoomLevel(7, true);
        mapViewContainer.addView(mapView);
        mapView.setPOIItemEventListener(this);
        requirePermission();
        ImageButton mypageButton = (ImageButton) findViewById(R.id.mypage_button);
        mypageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MyPageintent = new Intent(getApplicationContext(), MypageActivity.class);
                startActivity(MyPageintent);
            }
        });//내 페이지 버튼


        ImageButton imageButtonbutton = (ImageButton) findViewById(R.id.camera_button);
        imageButtonbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean camera = ContextCompat.checkSelfPermission(v.getContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
                boolean write = ContextCompat.checkSelfPermission
                        (v.getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
                if (camera && write) {
                    //사진찍은 인텐트 코드 넣기
                    dispatchTakePictureIntent();
                } else {
                    Toast.makeText(MainActivity.this, "카메라 권한 및 쓰기 권한을 주지 않았습니다.", Toast.LENGTH_SHORT).show();
                }

            }
        });// 사진 버튼


        //현재 위치 마커
        marker = new MapMarkerVO();
        marker.setLatitude(0);
        marker.setLongtitude(0);
        //경로찾기
//        Button bt = findViewById(R.id.button);
//
//        bt.setOnClickListener(new View.OnClickListener() {
//
//         @Override
//         public void onClick(View v) {
//             Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("daummaps://route?sp="+marker.getLatitude()+","+marker.getLongtitude()+"+&ep=37.37.2706008,127.01357559999997&by=CAR"));
//             startActivity(intent);
//
//          }
//     });
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void showAll() {
        int padding = 20;
        float minZoomLevel = 7;
        float maxZoomLevel = 10;
        MapPointBounds bounds = new MapPointBounds(MapPoint.mapPointWithGeoCoord(37.2706008, 127.01357559999997), MapPoint.mapPointWithGeoCoord(37.2706008, 127.01357559999997));
        mapView.moveCamera(CameraUpdateFactory.newMapPointBounds(bounds, padding, minZoomLevel, maxZoomLevel));
    }
    private void createCustomMarker(MapView mapView,Bitmap bitmap) {// 마커 이미지 띄우는 메소드

        mCustomMarker = new MapPOIItem();
        String name = "More";
        mCustomMarker.setItemName(name);
        mCustomMarker.setTag(1);
        mCustomMarker.setMapPoint(MapPoint.mapPointWithGeoCoord(37.2706008, 127.01357559999997));
        mCustomMarker.setMarkerType(MapPOIItem.MarkerType.CustomImage);
        Matrix matrix = new Matrix();
        matrix.postRotate(90);    //회전시킬 각도
        Bitmap newBmp = Bitmap.createBitmap(bitmap, 0, 0, //bmp를 matrix로 회전하여 newBmp에
                bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        mCustomMarker.setCustomImageBitmap(newBmp);

        // mCustomMarker.setCustomImageResourceId(R.drawable.custom_callout_balloon);
        mCustomMarker.setCustomImageAutoscale(false);
        mCustomMarker.setCustomImageAnchor(0.5f, 1.0f);

        mapView.addPOIItem(mCustomMarker);
        mapView.selectPOIItem(mCustomMarker, true);
        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(37.2706008, 127.01357559999997), false);

    }


    private void createCustomBitmapMarker(MapView mapView) {
        mCustomBmMarker = new MapPOIItem();
        String name = "More";
        mCustomBmMarker.setItemName(name);
        mCustomBmMarker.setTag(2);
        mCustomBmMarker.setMapPoint(MapPoint.mapPointWithGeoCoord(37.2706008, 127.01357559999997));
        mCustomBmMarker.setMarkerType(MapPOIItem.MarkerType.CustomImage);
        Bitmap bm = BitmapFactory.decodeResource(getResources(),R.drawable.custom_callout_balloon);
        mCustomBmMarker.setCustomImageBitmap(bm);
        mCustomBmMarker.setCustomImageAutoscale(false);
        mCustomBmMarker.setCustomImageAnchor(0.5f, 0.5f);
        mCustomMarker.setUserObject(R.layout.custom_callout_balloon);

        mapView.addPOIItem(mCustomBmMarker);
        mapView.selectPOIItem(mCustomBmMarker, true);
        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(37.2706008, 127.01357559999997), false);
    }

    public static Bitmap rotateImage(Bitmap source, float angle) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);

    }

    void requirePermission() {  //카메라
        String[] permissions = new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        ArrayList<String> listPermissionsNeeded = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_DENIED) {
                listPermissionsNeeded.add(permission);
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), 1);

        }
    }

    void takePicture() {   //카메라
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            File phtoFile = createImageFile();
            Uri photoUri = FileProvider.getUriForFile(this, "com.example.picup.fileprovider", phtoFile);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
            startActivityForResult(intent, 10);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents

        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.picup.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        super.onActivityResult(requestCode, resultCode, data);
        try {
            switch (requestCode) {
                case REQUEST_TAKE_PHOTO: {
                    if (resultCode == RESULT_OK) {
                        File file = new File(mCurrentPhotoPath);
                        Bitmap bitmap = MediaStore.Images.Media
                                .getBitmap(getContentResolver(), Uri.fromFile(file));

                        if (bitmap != null) {
                            createCustomMarker(mapView,bitmap); // 사진 찍은 위치에 마커찍기
                            ByteArrayOutputStream bstream = new ByteArrayOutputStream();
                            float scale = (float) (1024/(float)bitmap.getWidth());
                            int image_w = (int) (bitmap.getWidth() * scale);
                            int image_h = (int) (bitmap.getHeight() * scale);
                            Bitmap resize = Bitmap.createScaledBitmap(bitmap, image_w, image_h, true);
                            resize.compress(Bitmap.CompressFormat.JPEG, 100, bstream);
                            byte[] byteArray = bstream.toByteArray();
                            Intent intent = new Intent(MainActivity.this, PostActivity.class);
                            intent.putExtra("image", byteArray);
                            startActivity(intent);
                        }
                    }
                    break;
                }
            }

        } catch (Exception error) {
            error.printStackTrace();
        }

    }

    public void showMap (Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.activity_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.Login:
                Intent Loginintent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(Loginintent);
                break;
            case R.id.MyPage:
                Intent MyPageintent=new Intent(getApplicationContext(),MypageActivity.class);
                startActivity(MyPageintent);

        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onPOIItemSelected(MapView mapView, MapPOIItem mapPOIItem) {


    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem) {

    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem, MapPOIItem.CalloutBalloonButtonType calloutBalloonButtonType) {
        Intent Timelineintent=new Intent(getApplicationContext(),TimelineActivity.class);
        startActivity(Timelineintent);

    }

    @Override
    public void onDraggablePOIItemMoved(MapView mapView, MapPOIItem mapPOIItem, MapPoint mapPoint) {

    }

    @Override
    public void onReverseGeoCoderFoundAddress(MapReverseGeoCoder mapReverseGeoCoder, String s) {

    }

    @Override
    public void onReverseGeoCoderFailedToFindAddress(MapReverseGeoCoder mapReverseGeoCoder) {

    }

    @Override
    public void onCurrentLocationUpdate(MapView mapView, MapPoint mapPoint, float v) {
        marker.setLatitude( mapPoint.getMapPointGeoCoord().latitude);
        marker.setLongtitude( mapPoint.getMapPointGeoCoord().longitude);

        Log.d("위치:",marker.toString());

    }

    @Override
    public void onCurrentLocationDeviceHeadingUpdate(MapView mapView, float v) {

    }

    @Override
    public void onCurrentLocationUpdateFailed(MapView mapView) {

    }

    @Override
    public void onCurrentLocationUpdateCancelled(MapView mapView) {

    }


}