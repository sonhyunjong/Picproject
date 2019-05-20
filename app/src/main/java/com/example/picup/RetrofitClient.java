package com.example.picup;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL="http://172.30.2.117:8888/";
    private static RetrofitClient mInstance;
    private static Retrofit retrofit=null;

    public static Retrofit getClient(String url){
        if(retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public static synchronized RetrofitClient getInstance(){
        if(mInstance==null) {
            mInstance = new RetrofitClient();
        }
        return mInstance;
        }
    public UserService getApi(){
        return retrofit.create(UserService.class);
    }
}

