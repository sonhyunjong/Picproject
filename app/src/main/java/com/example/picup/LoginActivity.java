package com.example.picup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.picup.model.ResObj;
import com.example.picup.UserService;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    EditText edtUserId;
    EditText edtPassword;
    Button btnLogin;
    UserService userService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUserId=(EditText)findViewById(R.id.idText);
        edtPassword=(EditText)findViewById(R.id.passwordText);
        btnLogin=(Button)findViewById(R.id.loginButton);
        userService= ApiUtils.getUserService();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edtUserId.getText().toString().equals("")||edtPassword.getText().toString().equals("")){
                    Toast.makeText(LoginActivity.this, "아이디 또는 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                }

                try {
                    //LoginRequest logRequest = new LoginRequest(edtUserId.getText().toString(),edtPassword.getText().toString());

                    HashMap<String, String> input = new HashMap<>();
                    input.put("userId", edtUserId.getText().toString());
                    input.put("userPassword", edtPassword.getText().toString());


                    Retrofit retrofit = new Retrofit.Builder().baseUrl("http://172.30.2.117:8888/")
                            .addConverterFactory(GsonConverterFactory.create()).build();
                    UserService loginApi = retrofit.create(UserService.class);


                    loginApi.login(input).enqueue(new Callback<ResObj>() {
                        @Override
                        public void onResponse(Call<ResObj> call, Response<ResObj> response) {
                            if (response.isSuccessful()) {
                                ResObj map = response.body();
                                if (map != null) {
                                    switch (map.getResult()) {
                                        case -2:
                                            Toast.makeText(LoginActivity.this, "데이터베이스 오류로 인한 로그인 불가", Toast.LENGTH_SHORT).show();
                                            break;
                                        case -1:
                                            Toast.makeText(LoginActivity.this, "가입되지 않은 유저 입니다.", Toast.LENGTH_SHORT).show();
                                            break;
                                        case 0:
                                            Toast.makeText(LoginActivity.this, "비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show();
                                            break;
                                        case 1:
                                            Toast.makeText(LoginActivity.this, "로그인 입니다.", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                            startActivity(intent);
                                            Log.d("12321" , map.getUser().getUserName());
                                            break;
                                    }
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<ResObj> call, Throwable t) {
                            t.printStackTrace();
                            Log.d("12321" ,"fail");
                        }
                    });
                }catch (Exception e){
                    e.printStackTrace();
                }
                //startActivity(new Intent(LoginActivity.this,MainActivity.class));


            }

        });
        Button joinButton=findViewById(R.id.joinButton);
        joinButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
}