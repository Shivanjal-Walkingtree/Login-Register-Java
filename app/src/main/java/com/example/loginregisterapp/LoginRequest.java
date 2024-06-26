package com.example.loginregisterapp;

public class LoginRequest {

    private String email;
    private  String password;
    private int isGoogleAuth =0;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsGoogleAuth() {
        return isGoogleAuth;
    }

    public void setIsGoogleAuth(int isGoogleAuth) {
        this.isGoogleAuth = isGoogleAuth;
    }
}
