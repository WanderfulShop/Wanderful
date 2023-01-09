package com.codeup.adlister.models;

import java.io.Serializable;

public class LoginRequest implements Serializable {
    private String userName;
    private String password;
    private String errorMessage;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }


    public LoginRequest(String userName, String password, String errorMessage){
        this.userName = userName;
        this.password = password;
        this.errorMessage = errorMessage;
    }

    public LoginRequest(String userName, String password){
        this.userName = userName;
        this.password = password;
    }


}
