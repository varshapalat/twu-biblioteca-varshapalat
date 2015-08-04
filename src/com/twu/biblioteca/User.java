package com.twu.biblioteca;

public class User {
    String loginId;
    String password;
    public User(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }

    public boolean validate(String loginId, String password) {
        if(loginId.equals(this.loginId) && password.equals(this.password))
            return true;
        else
            return false;
    }
}
