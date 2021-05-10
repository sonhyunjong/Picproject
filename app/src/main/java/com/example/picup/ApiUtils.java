package com.example.picup;

import com.example.picup.UserService;

public class ApiUtils {

<<<<<<< HEAD
    public static final String BASE_URL="http://52.78.148.203:8888/";
=======
    public static final String BASE_URL="http://172.30.3.25:8888/";
>>>>>>> 0ca01f0bcb8051481652daf3e19224866d19480f
    public static UserService getUserService(){
        return RetrofitClient.getClient(BASE_URL).create(UserService.class);
    }
}
