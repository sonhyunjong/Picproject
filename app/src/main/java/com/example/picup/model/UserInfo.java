package com.example.picup.model;

public class UserInfo {
    String _id;
    String userId;
    String userPassword;
    String userName;

    public UserInfo(String _id, String userId, String userPassword, String userName) {
        this._id = _id;
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
    }

    public String get_id() { return _id; }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
