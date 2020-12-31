package com.example.firebasecrud;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Belal on 2/26/2017.
 */
@IgnoreExtraProperties
public class User {
    private String userId;
    private String userName;
    private String userMobile;
    private String userPass;
    private String userRole;

    public User() {
        //this constructor is required
    }

    public User(String userId, String userName, String userMobile, String userPass) {
        this.userId = userId;
        this.userName = userName;
        this.userMobile = userMobile;
        this.userPass = userPass;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
}