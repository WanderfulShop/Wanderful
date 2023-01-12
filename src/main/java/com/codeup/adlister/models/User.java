package com.codeup.adlister.models;

import com.codeup.adlister.util.Password;

import java.io.Serializable;

// This is a BEAN!
public class User implements Serializable {
    private int id;
    private String userName;
    private String firstName;
    private String lastName;
    private String school;
    private String email;
    private String password;

    public User() {}

    public User(int id, String userName, String firstName, String lastName, String school, String email, String password) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.school = school;
        this.email = email;
        setPassword(password);
    }

    public User(String userName, String firstName, String lastName, String school, String email, String password) {

        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.school = school;
        this.email = email;
        setPassword(password);
    }

    // getters and setters...

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = Password.hash(password);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
