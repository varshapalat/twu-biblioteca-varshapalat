package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AuthenticatorTest {
    @Test
    public void authenticateAUser() {
        User userOne = new User("123-4567", "qwerty", "librarian", "123-4567", "qwerty", "librarian");
        User userTwo = new User("123-4567", "qwerty", "librarian", "abc-defg", "qwerty", "customer");
        User userThree = new User("123-4567", "qwerty", "librarian", "var-shap", "qwerty", "customer");

        ArrayList<User> UserList = new ArrayList<User>();
        UserList.add(userOne);
        UserList.add(userTwo);
        UserList.add(userThree);

        Authenticator authenticator = new Authenticator(UserList);

        assertEquals("librarian", authenticator.authenticate("123-4567", "qwerty"));
    }
}
