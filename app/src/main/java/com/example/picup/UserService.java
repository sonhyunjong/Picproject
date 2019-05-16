package com.example.picup;

import com.example.picup.model.ResObj;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {
    @FormUrlEncoded
    @POST("login/")
    Call<ResObj> login(@FieldMap HashMap<String, String> map);

    @POST("join/")
    @FormUrlEncoded
    Call<ResObj> join(@Field("userId") String userId,
                      @Field("userPassword") String userPassword,
                      @Field("userName") String userName,
                      @Field("userGender") String userGender,
                      @Field("userBirth")String userBirth);

   /* @Multipart
    @PUT("user/photo")
    Call<User> updateUser(@Part("photo") RequestBody photo, @Part("description") RequestBody description);*/
}
