package com.twu.biblioteca;

public class User {
    private String loginId;
    private String password;
    private String role;

    public User(String loginId, String password, String role) {
        this.loginId = loginId;
        this.password = password;
        this.role = role;
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
}