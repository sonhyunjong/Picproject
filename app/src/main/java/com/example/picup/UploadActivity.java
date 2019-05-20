/*

package com.example.picup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.picup.model.ResObj;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UploadActivity extends AppCompatActivity implements  View.OnClickListener{

    Button btUpload;
    UserService userService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);


        btUpload = (Button) findViewById(R.id.btUpload);

        userService = ApiUtils.getUserService();

        btUpload.setOnClickListener(this);

        int result = edtUserGender.getCheckedRadioButtonId();  // 결과를 출력할 문자열  ,  항상 스트링은 빈문자열로 초기화 하는 습관을 가지자
        RadioButton rb = (RadioButton) findViewById(result);

        String userId = edtUserId.getText().toString().trim();
        String userPassword = edtPassword.getText().toString().trim();
        String userName = edtUserName.getText().toString().trim();
        String userBirth = edtUserBirth.getText().toString().trim();
        String userGender = rb.getText().toString().trim();

    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.joinButton:
                userSignUp();
                break;
        }
    }


    private void userSignUp() {
        int result = edtUserGender.getCheckedRadioButtonId();  // 결과를 출력할 문자열  ,  항상 스트링은 빈문자열로 초기화 하는 습관을 가지자
        RadioButton rb = (RadioButton) findViewById(result);

        String id = edtUserId.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        String name = edtUserName.getText().toString().trim();
        String birth = edtUserBirth.getText().toString().trim();
        String gender = rb.getText().toString().trim();

        if (id.isEmpty()){
            edtUserId.setError("Id is required");
            edtUserId.requestFocus();
            return;
        }

        if(password.isEmpty()){
            edtPassword.setError("Password required");
            edtPassword.requestFocus();
            return;
        }

        if(password.length()<2) {
            edtPassword.setError("Password should be 2 character long");//2자리 이상 입력
            edtPassword.requestFocus();
            return;
        }

        if(name.isEmpty()){
            edtUserName.setError("Name required");
            edtUserName.requestFocus();
            return;
        }
        if(birth.isEmpty()){
            edtPassword.setError("Birth required");
            edtPassword.requestFocus();
            return;
        }


        Call<ResObj> call=RetrofitClient
                .getInstance()
                .getApi()
                .join(id,password,name,gender,birth);



        call.enqueue(new Callback<ResObj>() {
            @Override
            public void onResponse(Call<ResObj> call, Response<ResObj> response) {

                String s = response.body().toString();
                Log.d("12321", "success");

            }

            @Override
            public void onFailure(Call<ResObj> call, Throwable t) {
                t.printStackTrace();
                Log.d("12321", "fail");
            }
        });
    }
}
*/
