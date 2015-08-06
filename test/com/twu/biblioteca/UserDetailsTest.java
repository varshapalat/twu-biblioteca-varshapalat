package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class UserDetailsTest {

    @Test
    public void foo() {
        User userOne = new User("123-4567", "qwerty", "librarian", "Ram", "ram@gmail.com", "999999999");
        User userTwo = new User("abc-defg", "qwerty", "customer", "Nancy", "nancy@gmail.com", "8888888888");
        User userThree = new User("var-shap", "qwerty", "customer", "Varsha", "varsha@gmail.com", "7777777777");

        ArrayList<User> userList = new ArrayList<User>();
        userList.add(userOne);
        userList.add(userTwo);
        userList.add(userThree);
        String login = "123-4567";

        UserDetails userDetails = new UserDetails(userList);
        assertEquals("123-4567\tRam\tram@gmail.com\t999999999", userDetails.getDetailsOf(login));
    }
}
