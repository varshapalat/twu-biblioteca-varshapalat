package com.twu.biblioteca.com.controller;

import com.twu.biblioteca.com.model.User;

import java.util.ArrayList;

public class Authenticator {
    private ArrayList<User> userList;

    public Authenticator(ArrayList<User> userList) {
        this.userList = userList;
    }

    public String authenticate(String loginId, String password) {
        for (User anUserList : userList) {
            if (anUserList.hasUser(loginId, password)) {
                return anUserList.getRole();
            }
        }
        return "no role";
    }
}
