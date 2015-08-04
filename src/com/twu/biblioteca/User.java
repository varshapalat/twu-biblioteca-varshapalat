package com.twu.biblioteca;

public class User {
    String loginId;
    String password;
    String role;
    public User(String loginId, String password, String role) {
        this.loginId = loginId;
        this.password = password;
        this.role = role;
    }

    public boolean validate(String loginId, String password) {
        if(loginId.equals(this.loginId) && password.equals(this.password))
            return true;
        else
            return false;
    }
}
