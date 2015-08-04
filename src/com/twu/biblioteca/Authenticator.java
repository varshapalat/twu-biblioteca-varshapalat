package com.twu.biblioteca;

import java.util.ArrayList;

public class Authenticator {
    ArrayList<User> userList;
    public Authenticator(ArrayList<User> userList) {
        this.userList = userList;
    }

    public boolean authenticate(String loginId, String password) {
        for (User anUserList : userList) {
            if ((loginId.equals(anUserList.loginId)) && password.equals(anUserList.password))
                return true;
        }
        return false;
    }
}
