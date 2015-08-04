package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AuthenticatorTest {
    @Test
    public void authenticateAUser() {
        User userOne = new User("123-4567", "qwerty");
        User userTwo = new User("abc-defg", "qwerty");
        User userThree = new User("var-shap", "qwerty");

        ArrayList<User> UserList = new ArrayList<User>();
        UserList.add(userOne);
        UserList.add(userTwo);
        UserList.add(userThree);

        Authenticator authenticator = new Authenticator(UserList);

        assertEquals(true, authenticator.authenticate("123-4567", "qwerty"));
    }
}
