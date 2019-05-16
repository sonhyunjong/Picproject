package com.example.picup;

public class JoinRequest {



    private final  String userId;

    private final String userPassword;

    private final String userName;

    private final String userGender;

    private final String userBirth;

    public JoinRequest(String userId, String userPassword,String userName,String userGender,String userBirth) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userBirth=userBirth;
        this.userGender=userGender;
        this.userName=userName;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserGender() {
        return userGender;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public String getUserId() {
        return userId;
    }
    public String getUserPassword() {
        return userPassword;
    }



    @Override
    public String toString() {
        return "ID:"+this.getUserId()+" , PASSWORD: "+ this.getUserPassword()+" , NAME: "+ this.getUserName()+" , GENDER: "+ this.getUserGender()+", BIRTH: "+ this.getUserBirth();
    }


    public static class JoinActivity {
    }
}
