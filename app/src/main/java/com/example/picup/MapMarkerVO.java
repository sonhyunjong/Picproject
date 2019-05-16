package com.example.picup;

public class MapMarkerVO {
    double latitude;
    double longtitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    @Override
    public String toString() {
        return "경도:"+this.getLatitude()+" , 위도: "+ this.getLongtitude();
    }

    public static class LoginActivity {
    }
}
