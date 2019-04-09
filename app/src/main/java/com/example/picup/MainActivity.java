package com.example.picup;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.media.DrmInitData;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import net.daum.android.map.MapViewEventListener;
import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapReverseGeoCoder;
import net.daum.mf.map.api.MapView;

import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;


public class MainActivity extends AppCompatActivity implements MapView.POIItemEventListener, MapView.CurrentLocationEventListener, MapReverseGeoCoder.ReverseGeoCodingResultListener{

    MapMarkerVO marker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MapView mapView = new MapView(this);
        MapPoint.GeoCoordinate mapPointGeo;

        mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading);
        mapView.setDaumMapApiKey("ead955228613545283791950dc488bac");
        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(37.53737528, 127.00557633), true);
        mapView.setZoomLevel(7, true);
        mapViewContainer.addView(mapView);
        mapView.setPOIItemEventListener(this);
        //출발 마커 추가하기
        MapPOIItem marker1 = new MapPOIItem();
        marker1.setItemName("Departure");
        marker1.setTag(0);
        marker1.setMapPoint(MapPoint.mapPointWithGeoCoord(37.53737528, 127.00557633));
        marker1.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker1.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.addPOIItem(marker1);
        // 도착 마커 추가하기
        MapPOIItem marker2 = new MapPOIItem();
        marker2.setItemName("Arrival");
        marker2.setTag(0);
        marker2.setMapPoint(MapPoint.mapPointWithGeoCoord(37.2706008, 127.01357559999997));
        marker2.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker2.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.addPOIItem(marker2);
        mapView.setCurrentLocationEventListener((MapView.CurrentLocationEventListener) this);

        marker = new MapMarkerVO();
        marker.setLatitude(0);
        marker.setLongtitude(0);
        //경로찾기
        Button bt = findViewById(R.id.button);

        bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("daummaps://route?sp="+marker.getLatitude()+","+marker.getLongtitude()+"+&ep=37.4979502,127.0276368&by=CAR"));
                startActivity(intent);

            }
        });


    }







        @Override
    public void onPOIItemSelected(MapView mapView, MapPOIItem mapPOIItem) {


    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem) {


    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem, MapPOIItem.CalloutBalloonButtonType calloutBalloonButtonType) {

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
