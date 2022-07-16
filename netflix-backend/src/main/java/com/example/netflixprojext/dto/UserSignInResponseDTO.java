package com.example.netflixprojext.dto;

public class UserSignInResponseDTO {

    private boolean doesUserExist;

    private String userToken;

    public boolean isDoesUserExist() {
        return doesUserExist;
    }

    public void setDoesUserExist(boolean doesUserExist) {
        this.doesUserExist = doesUserExist;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }
}
