package com.twu.biblioteca;

import java.util.ArrayList;

public class UserDetails {
    ArrayList<User> userList;
    public UserDetails(ArrayList<User> userList) {
        this.userList = userList;
    }

    public String getDetailsOf(String login) {
        String details;
        for(User user: userList) {
            details = user.getUserDetails(login);
            if (!details.equals("Not found"))
                return details;
        }
        return "Not found";
    }
}
