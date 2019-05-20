package com.example.picup;

import com.example.picup.UserService;

public class ApiUtils {

    public static final String BASE_URL="http://172.30.2.117:8888/";
    public static UserService getUserService(){
        return RetrofitClient.getClient(BASE_URL).create(UserService.class);
    }
}
