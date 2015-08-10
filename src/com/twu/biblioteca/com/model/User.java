package com.twu.biblioteca.com.model;

public class User {
    private  String name;
    private String loginId;
    private String password;
    private String role;
    private String emailId;
    private String phoneNumber;

    public User(String loginId, String password, String role, String name, String emailId, String phoneNumber) {
        this.loginId = loginId;
        this.password = password;
        this.role = role;
        this.name = name;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
    }


    public boolean hasUser(String thatLoginId, String thatPassword) {
        if(thatLoginId.equals(this.loginId) && thatPassword.equals(this.password))
            return true;
        else
            return false;
    }

    public String getRole() {
        return role;
    }

    public String getLoginId() {
        return loginId;
    }

    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUserDetails(String thatLoginId) {
        if(thatLoginId.equals(this.loginId))
            return loginId +"\t"+ name +"\t" +emailId +"\t"+ phoneNumber ;
        return "Not found";
    }
}